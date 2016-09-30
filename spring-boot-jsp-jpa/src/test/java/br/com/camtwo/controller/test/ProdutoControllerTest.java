package br.com.camtwo.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.camtwo.spring.jspjpa.MainServer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=MainServer.class)
@AutoConfigureMockMvc
public class ProdutoControllerTest {

	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;

	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void testInserirProduto() throws Exception {
		mvc.perform(post("/produto/").param("nome", "Produto de teste").param("valor", "10.0"))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/produto/"));
	}

}
