package br.com.camtwo.controller.test;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.camtwo.spring.jspjpa.MainServer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=MainServer.class)
@AutoConfigureMockMvc
public class IndexControllerTest {

	
	 @Autowired
	 private MockMvc mvc;
	 
	@Test
	public void testIndexControllerGetConteudo() throws Exception {
		
		 mvc.perform(MockMvcRequestBuilders.get("/index"))
         .andExpect(status().isOk())
         .andExpect(content().string(equalTo("index")));
		
	}

}



