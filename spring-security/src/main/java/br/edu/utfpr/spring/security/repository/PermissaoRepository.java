package br.edu.utfpr.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.spring.security.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

	Permissao findByPermissao(String permissao);
}
