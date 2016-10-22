package br.edu.utfpr.spring.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.spring.mvc.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

	Permissao findByPermissao(String permissao);

}
