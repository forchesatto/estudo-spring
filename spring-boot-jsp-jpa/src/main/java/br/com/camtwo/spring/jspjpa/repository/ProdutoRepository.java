package br.com.camtwo.spring.jspjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.camtwo.spring.jspjpa.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
