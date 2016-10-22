package br.edu.utfpr.spring.mvc.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.edu.utfpr.spring.mvc.model.Usuario;
import br.edu.utfpr.spring.mvc.repository.UsuarioRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UsuarioService implements UserDetailsService{

	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(username);
		if(usuario != null){
			return usuario;
		} else {
			throw new UsernameNotFoundException("Usuário inválido");
		}
	}

}
