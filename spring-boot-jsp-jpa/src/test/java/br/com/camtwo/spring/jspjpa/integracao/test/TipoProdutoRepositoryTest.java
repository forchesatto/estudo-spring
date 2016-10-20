package br.com.camtwo.spring.jspjpa.integracao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import br.com.camtwo.spring.jspjpa.MainServer;
import br.com.camtwo.spring.jspjpa.domain.TipoProduto;
import br.com.camtwo.spring.jspjpa.repository.TipoProdutoRepository;

@RunWith(SpringRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@SpringBootTest(classes=MainServer.class)
public class TipoProdutoRepositoryTest {

	@Autowired
	private TipoProdutoRepository tipoProdutoRepository;
	
	@Test
	@DatabaseSetup("/dataSet/tipoProduto.xml")
	public void testFind() throws Exception {
		List<TipoProduto> personList = tipoProdutoRepository.findAll();
		assertEquals(1, personList.size());
		assertEquals("banana", personList.get(0).getNome());
	}
}
