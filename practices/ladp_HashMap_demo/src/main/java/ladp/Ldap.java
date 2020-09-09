package ladp;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.CommunicationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.springframework.stereotype.Component;

@Component
public class Ldap {
	private static final String LDAP_URL = "ldap://10.43.173.180:389";
	private static final String ADMIN_NAME = "cn=root";
	private static final String ADMIN_PASSWORD = "secret";
	private static final String CONTEXT_FACTORY = "com.sun.jndi.ldap.LdapCtxFactory";

	private int searchLdapRetryCount = 3;
	private int retrySleepTime = 1;

	private InitialDirContext connect() {
		Hashtable<String, String> env = new Hashtable<>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, CONTEXT_FACTORY);
		env.put(Context.PROVIDER_URL, LDAP_URL);
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, ADMIN_NAME);
		env.put(Context.SECURITY_CREDENTIALS, ADMIN_PASSWORD);
		InitialDirContext ctx = null;
		try {
			ctx = new InitialDirContext(env);
			System.out.println("认证成功");
		}catch (javax.naming.AuthenticationException e) {
			System.out.println("认证失败");
		}catch (Exception e) {
			System.out.println("认证出错：" + e);
		}
		return ctx;
	}

	public List<Greeting> searchlist(String searchFilter) throws Exception {
		InitialDirContext ctx = connect();
		SearchControls searchCtls = new SearchControls();
		searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		searchCtls.setReturningAttributes(new String[] { "mailLogin", "airMailLogin", "airMailPassword", "plnFwdAddr" });
		NamingEnumeration<?> answer = null;
		List<Greeting> greetingList = new ArrayList<>();
		for (int i =0; i < searchLdapRetryCount + 1; i++) {
			try {
				answer = ctx.search("", searchFilter, searchCtls);
				while (answer.hasMoreElements()) {
					Greeting greeting = new Greeting();
					SearchResult sr = (SearchResult) answer.next();
					Attributes attrs = sr.getAttributes();
					if (attrs != null) {
						greeting.setMailLogin((String) attrs.get("mailLogin").get());
						greeting.setAirMailLogin((String) attrs.get("airMailLogin").get());
						greeting.setAirMailPassword((String) attrs.get("airMailPassword").get());
						List<String> plnFwdAddrs = new ArrayList<>();
						for (NamingEnumeration<?> ne = attrs.get("plnFwdAddr").getAll(); ne.hasMore(); ) {
							plnFwdAddrs.add((String) ne.next());
						}
						greeting.setPlnFwdAddr(plnFwdAddrs);
						greetingList.add(greeting);
					}
					System.out.println("toString: " + greeting.toString());
				}
				break;
			} catch(CommunicationException e) {
				if (i == searchLdapRetryCount) {
					System.out.println("超过查询retry上限，查询失败");
					throw e;
				}
				
				System.out.println("Search Retry:" + (i + 1) + "times.");
				Thread.sleep(retrySleepTime);
			} catch(Exception e) {
				System.out.println("检索失败");
				throw e;
			} finally {
				close(ctx);
			}
		}
		return greetingList;
	}

	private void close(InitialDirContext ctx) {
		if (ctx != null) {
			try {
				ctx.close();
			}catch (NamingException e) {
				System.out.println("NamingException in close():" + e);
			}
		}
	}

}
