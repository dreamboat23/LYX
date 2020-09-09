package ladp;

import org.springframework.beans.factory.annotation.Autowired;

public class StringDemo {

	@Autowired
	private Ldap ldap;

	public static void main(String[] args) {
		ThreeKeys();
	}

	public static void ThreeKeys() {
		byte[] bytes = new byte[256];
		String keys = "mailLogin1, mailLogin2, mailLogin3";
		String[] mailLogin = keys.split(",| ");
		for (String i : mailLogin) {
			System.out.println(i);
		}
	}
}
