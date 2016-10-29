package br.com.camtwo.spring.boot.microservice.produto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.camtwo.spring.boot.microservice.produto.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	@Query("select distinct p from Produto p left join fetch p.tipoProduto")
	List<Produto> findAllEager();
	
	@EntityGraph(value="Produto.tipoProduto", type=EntityGraphType.FETCH)
	List<Produto> findByNome(String nome);
	
	
}
