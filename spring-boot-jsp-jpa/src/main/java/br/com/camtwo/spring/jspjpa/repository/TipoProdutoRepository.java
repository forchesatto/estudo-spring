package br.com.camtwo.spring.jspjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.camtwo.spring.jspjpa.domain.TipoProduto;


@RepositoryRestResource(collectionResourceRel = "tipoProduto", path = "tiposProduto")
public interface TipoProdutoRepository extends JpaRepository<TipoProduto, Long> {

}
