package br.com.camtwo.controller.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.camtwo.spring.jspjpa.MainServer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MainServer.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@DirtiesContext
public class IndexControllerTest {

	@Value("${local.server.port}")
	private int port;

	@Test
	public void testIndexControllerGetConteudo() throws Exception {
		ResponseEntity<String> pagina = new TestRestTemplate().getForEntity(
				"http://localhost:" + this.port, String.class);
		assertEquals(HttpStatus.OK, pagina.getStatusCode());
		assertTrue(pagina.getBody().contains(
				"Testes Spring-Boot + JSP + Spring-data-JPA"));
	}

}
