/*
 * 版权声明
 */
package ladp;

import java.util.List;

/**
 * 类注释
 * @author liuyongx
 *
 */
public class Greeting {

	/** 字段注释 */
	private String mailLogin;
	private String airMailLogin;
	private String airMailPassword;
	private List<String> plnFwdAddr;
	/**
	 *方法注释 
	 * @param airMailLogin
	 */
	public String getMailLogin() {
		return mailLogin;
	}

	public void setMailLogin(String mailLogin) {
		this.mailLogin = mailLogin;
	}

	public String getAirMailLogin() {
		return airMailLogin;
	}

	public void setAirMailLogin(String airMailLogin) {
		this.airMailLogin = airMailLogin;
	}

	public String getAirMailPassword() {
		return airMailPassword;
	}

	public void setAirMailPassword(String airMailPassword) {
		this.airMailPassword = airMailPassword;
	}

	public List<String> getPlnFwdAddr() {
		return plnFwdAddr;
	}

	public void setPlnFwdAddr(List<String> plnFwdAddr) {
		this.plnFwdAddr = plnFwdAddr;
	}
	
	@Override
	public String toString() {
		return "{" + "\n" +  "mailLogin: " + mailLogin + "," 
					+ "\n" + "airMailLogin=" + airMailLogin + "," 
					+ "\n" + "airMailPassword=" + airMailPassword + "," 
					+ "\n" + "plnFwdAddr=" + plnFwdAddr + "\n" + "}";
	}
}
