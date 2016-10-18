package br.edu.utfpr.spring.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.utfpr.spring.mvc.model.LabelValue;
import br.edu.utfpr.spring.mvc.model.TipoProduto;


public interface TipoProdutoRepository 
			extends JpaRepository<TipoProduto, Long> {

	List<TipoProduto> findByNomeLike(String nome);
	
	@Query("select tp from TipoProduto tp where tp.valorMinimo < ?1")
	List<TipoProduto> buscarValorMinimoMenorQue(Double valorMinimo);

	@Query("select new br.edu.utfpr.spring.mvc.model.LabelValue(tp.nome, tp.codigo) "
			+ "from TipoProduto tp where tp.nome like ?1")
	List<LabelValue> findAutoComplete(String termo);
}
