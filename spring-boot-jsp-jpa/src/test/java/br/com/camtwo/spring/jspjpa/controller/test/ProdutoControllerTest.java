package br.com.camtwo.spring.jspjpa.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.camtwo.spring.jspjpa.controller.ProdutoController;
import br.com.camtwo.spring.jspjpa.repository.ProdutoRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ProdutoController.class)
public class ProdutoControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ProdutoRepository produtoRepository;

	@Test
	public void testInserirProduto() throws Exception {
		mvc.perform(post("/produto/").param("nome", "Produto de teste").param("valor", "10.0"))
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/produto/"));
	}

}
