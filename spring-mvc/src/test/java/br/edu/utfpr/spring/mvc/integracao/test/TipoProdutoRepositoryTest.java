package br.edu.utfpr.spring.mvc.integracao.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import br.edu.utfpr.spring.mvc.Main;
import br.edu.utfpr.spring.mvc.model.TipoProduto;
import br.edu.utfpr.spring.mvc.repository.TipoProdutoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Main.class)
//Para DBUNIT
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
	DbUnitTestExecutionListener.class })
public class TipoProdutoRepositoryTest {
	
	@Autowired
	private TipoProdutoRepository tipoProdutoRepository;

	@Test
	@DatabaseSetup(type=DatabaseOperation.DELETE_ALL, value="/dataSet/limpaBase.xml")
	@DatabaseSetup("/dataSet/tipoProduto.xml")
	public void deveRetornarPeloNome(){
		List<TipoProduto> tiposProdutos = tipoProdutoRepository.findByNomeLike("banana");
		assertEquals(1, tiposProdutos.size());
	}
}








