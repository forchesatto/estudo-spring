package br.edu.utfpr.spring.mvc.controller.test;



import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.edu.utfpr.spring.mvc.controller.IndexController;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers=IndexController.class)
public class IndexControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	@Ignore
	public void deveAcharIndex() throws Exception{
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.TEXT_HTML))
		.andExpect(status().isOk());
	}

}
