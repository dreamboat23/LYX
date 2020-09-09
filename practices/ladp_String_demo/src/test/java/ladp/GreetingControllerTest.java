package ladp;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = GreetingController.class, secure = false)
public class GreetingControllerTest {

	@MockBean
	private Ldap ldap;
	@Autowired
	private MockMvc mvc;

	@Test
	public void testSearchList() throws Exception {
		String searchFilter = "mailMessageStore=ami-db";
		PowerMockito.when(ldap.searchlist(searchFilter)).thenReturn(null);
		mvc.perform(MockMvcRequestBuilders.get("/greetinglist"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andReturn();
		Mockito.verify(ldap, Mockito.only()).searchlist(searchFilter);
	}

	@Test
	public void testSearch() throws Exception {
		String searchFilter = "mailLogin=00000000002010";
		PowerMockito.when(ldap.searchlist(searchFilter)).thenReturn(null);
		mvc.perform(MockMvcRequestBuilders.get("/greeting"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andReturn();
		Mockito.verify(ldap, Mockito.only()).searchlist(searchFilter);
	}

}
