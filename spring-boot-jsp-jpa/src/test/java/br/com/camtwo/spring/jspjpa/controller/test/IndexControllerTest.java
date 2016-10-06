package br.com.camtwo.spring.jspjpa.controller.test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.camtwo.spring.jspjpa.controller.IndexController;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers=IndexController.class)
public class IndexControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testIndexControllerGetConteudo() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.TEXT_HTML))
			.andExpect(status().isOk());
	}
	
	

}
