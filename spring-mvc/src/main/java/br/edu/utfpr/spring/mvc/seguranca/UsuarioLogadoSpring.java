package br.edu.utfpr.spring.mvc.seguranca;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import br.edu.utfpr.spring.mvc.model.Usuario;

@Component
public class UsuarioLogadoSpring implements UsuarioLogado {

	@Override
	public Optional<Usuario> get() {
		
		SecurityContext context = SecurityContextHolder.getContext();
		
		if(context != null){
			Authentication authentication = context.getAuthentication();
			if(authentication != null
					&& (authentication.getPrincipal() instanceof UserDetails)){
				return Optional.of((Usuario)authentication.getPrincipal());
			}
		}
		
		return Optional.empty();
	}

}
