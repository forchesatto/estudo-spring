package br.edu.utfpr.spring.mvc.integracao.test;

import static org.junit.Assert.assertNotNull;

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
import br.edu.utfpr.spring.mvc.model.Produto;
import br.edu.utfpr.spring.mvc.model.TipoProduto;
import br.edu.utfpr.spring.mvc.repository.ProdutoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Main.class)
//Para DBUNIT
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
	DbUnitTestExecutionListener.class })
public class ProdutoRepositoryTest {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Test
	@DatabaseSetup(type=DatabaseOperation.DELETE_ALL, value="/dataSet/limpaBase.xml")
	@DatabaseSetup("/dataSet/tipoProduto.xml")
	public void deveInserirProduto(){
		Produto produto = new Produto();
		produto.setNome("Produto Teste");
		produto.setValor(14.90);
		produto.setTipoProduto(new TipoProduto(1L));
		produto = produtoRepository.save(produto);
		Produto produtoBanco = produtoRepository.findOne(produto.getCodigo());
		assertNotNull(produtoBanco);
	}
	
}







