package ladp;

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
		List<Greeting> greeting = null;
		try {
			String searchFilter = "mailMessageStore=ami-db";
			greeting = ldap.searchlist(searchFilter);	
		} catch(Exception e) {

		}
		return greeting;
	}

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue = "World") String name) throws Exception {
		Greeting greeting = null;
		try {
			String searchFilter = "mailLogin=00000000002010";
			greeting = ldap.searchlist(searchFilter).get(0);
		} catch(Exception e) {

		}
		return greeting;
	}
}
