package ladp;

import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Ldap.class)
public class LdapTest {

	private Ldap ldap = new Ldap();

	@Test
	public void testSearchList() throws Exception {
		Vector<SearchResult> values = new Vector<SearchResult>();
		BasicAttributes attributes = new BasicAttributes();
		attributes.put("airMailLogin", "1");
		attributes.put("airMailPassword", "2");
		attributes.put("airNotificationType", "3");
		attributes.put("telephoneNumber", "4");
		SearchResult element = new SearchResult("SearchResult", new Object(), attributes);
		values.add(element);
		String searchFilter = "mailLogin=00000000002010";
		InitialDirContext ctx = PowerMockito.mock(InitialDirContext.class);
		PowerMockito.whenNew(InitialDirContext.class).withAnyArguments().thenReturn(ctx);//41、42行实现mock一个对象的初始化：ctx = new InitialDirContext(env);
			PowerMockito.when(ctx.search(ArgumentMatchers.anyString(), ArgumentMatchers.anyString(),
					ArgumentMatchers.any(SearchControls.class))).thenReturn(new MockNamingEnumeration<>(values));
		Mockito.doNothing().when(ctx).close();
		List<Greeting> greeting = ldap.searchlist(searchFilter);
		System.out.println(greeting);
	}

	class MockNamingEnumeration<SearchResult> implements NamingEnumeration<SearchResult> {
		Enumeration<SearchResult> list;

		public MockNamingEnumeration(Vector<SearchResult> values) {
			list = values.elements();
		}
		@Override
		public boolean hasMoreElements() {
			return list.hasMoreElements();
		}

		@Override
		public SearchResult nextElement() {
			return list.nextElement();
		}

		@Override
		public void close() throws NamingException {
			list = null;
		}

		@Override
		public boolean hasMore() throws NamingException {
			return list.hasMoreElements();
		}

		@Override
		public SearchResult next() throws NamingException {
			return list.nextElement();
		}
	}
}
