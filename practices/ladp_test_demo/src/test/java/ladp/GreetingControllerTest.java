package ladp;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = GreetingController.class, secure = false)
public class GreetingControllerTest {
	@Autowired
	private MockMvc mvc;
	@Test
	public void test() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/greetinglist"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andReturn();
	}

}
