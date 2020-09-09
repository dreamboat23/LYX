/*
 * 版权声明
 */
package ladp;

/**
 * 类注释
 * @author liuyongx
 *
 */
public class Greeting {

	/** 字段注释 */
	private String airMailLogin;
	private String airMailPassword;
	private String airNotificationType;
	private String telephoneNumber;

	public String getAirMailLogin() {
		return airMailLogin;
	}
	/**
	 *方法注释 
	 * @param airMailLogin
	 */
	public void setAirMailLogin(String airMailLogin) {
		this.airMailLogin = airMailLogin;
	}

	public String getAirMailPassword() {
		return airMailPassword;
	}

	public void setAirMailPassword(String airMailPassword) {
		this.airMailPassword = airMailPassword;
	}

	public String getAirNotificationType() {
		return airNotificationType;
	}

	public void setAirNotificationType(String airNotificationType) {
		this.airNotificationType = airNotificationType;
	}
	
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	
	public void setTelephoneNumber(String telephoneNumber) {
		// TODO Auto-generated method stub
		this.telephoneNumber = telephoneNumber;	
	}
	@Override
	public String toString() {
		return "Greeting [airMailLogin=" + airMailLogin + ", airMailPassword=" + airMailPassword
				+ ", airNotificationType=" + airNotificationType + ", telephoneNumber=" + telephoneNumber + "]";
	}

}
