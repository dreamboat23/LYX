package ladp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		String keys = "00000000000001, 00000000000002, 00000000000017";
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
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "200");
		Map<String, Object>[] data = new HashMap[greeting.size()];
		int index = 0;
		for (Greeting g : greeting) {
			Map<String, Object> gmap = new HashMap<String, Object>();
			gmap.put("mailLogin", g.getMailLogin());
			gmap.put("airmaillogin", g.getAirMailLogin());
			gmap.put("airmailpassword", g.getAirMailPassword());
			gmap.put("plnFwdAddr", g.getPlnFwdAddr());
			data[index] = gmap;
			index++;
		}
		map.put("data", data);
		System.out.println(map);
		List<Map> greetingLists = new ArrayList<>();
		Greeting greetings = new Greeting();
		for (int i = 0; i<data.length; i++) {
			greetingLists.add(data[i]);
			//输出：[{mailLogin=00000000000001, plnFwdAddr=[email1@xxx.net, email2@xxx.net, email3@xxx.net], airmailpassword=XSthpj6G, airmaillogin=h8uzjeuw}, {mailLogin=00000000000002, plnFwdAddr=[email1@xxx.net, email2@xxx.net], airmailpassword=PpF8Boes, airmaillogin=ijq9u9yf}, {mailLogin=00000000000017, plnFwdAddr=[email1@xxx.net], airmailpassword=3mFWN1et, airmaillogin=12345678}]
		}
		System.out.println(greetingLists);
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
