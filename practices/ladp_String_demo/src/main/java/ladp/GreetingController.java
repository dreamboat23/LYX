package ladp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@Autowired
	private Ldap ldap;

	@GetMapping("/greetinglist")
	//@RequestMapping("/greetinglist")
	public List<Greeting> greetinglist(@RequestParam(value="name", defaultValue = "World") String name) throws Exception {
		List<Greeting> greeting = new ArrayList<>();
		List<Greeting> greetingList = null;
		byte[] bytes = new byte[256];
		System.out.println(Arrays.toString(bytes));
		String keys = "00000000002010, 00000000000117, 00000000000001";
		byte[] keysBytes = keys.getBytes();
		System.out.println(Arrays.toString(keysBytes));
		System.arraycopy(keysBytes, 0, bytes, 0, keysBytes.length);
		System.out.println(Arrays.toString(bytes));
		String keysString = new String(bytes);
		System.out.println(keysString);
		keysString = keysString.trim();
		System.out.println(keysString);
		String[] mailLogin = keysString.split(",| ");
		try {
			for (String i : mailLogin) {
				System.out.println(i);
				String searchFilter = "mailLogin=".concat(i);
				greetingList = ldap.searchlist(searchFilter);
				if (greetingList != null && !greetingList.isEmpty()) {
					greeting.addAll(greetingList);
				}
			}
		} catch(Exception e) {

		}
		return greeting;
	}

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue = "World") String name) throws Exception {
		Greeting greeting = null;
		String keys = "00000000002010, 00000000000117, 00000000000001";
		String[] mailLogin = keys.split(",| ");
		try {
			String searchFilter = "mailLogin=".concat(mailLogin[0]);
			greeting = ldap.searchlist(searchFilter).get(0);
		} catch(Exception e) {

		}
		return greeting;
	}
}
