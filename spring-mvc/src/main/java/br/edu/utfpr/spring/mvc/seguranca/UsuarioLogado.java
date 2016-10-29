package br.edu.utfpr.spring.mvc.seguranca;

import java.util.Optional;

import br.edu.utfpr.spring.mvc.model.Usuario;

public interface UsuarioLogado {

	Optional<Usuario> get();
}
