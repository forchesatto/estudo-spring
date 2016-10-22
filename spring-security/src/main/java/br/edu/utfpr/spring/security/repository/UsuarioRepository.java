package br.edu.utfpr.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.spring.security.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);
}
