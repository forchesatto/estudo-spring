package br.edu.utfpr.spring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.edu.utfpr.spring.mvc.repository.UsuarioRepository;
import br.edu.utfpr.spring.mvc.service.UsuarioService;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		return  new UsuarioService(usuarioRepository);
	}
	/**
     * Bean responsável por criptografar a senha 
     * 	com base no {@link BCryptPasswordEncoder}
     * 
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService())
		.passwordEncoder(passwordEncoder());
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/static/**").permitAll();
		http.authorizeRequests().antMatchers("/usuario/**").permitAll();
		
		http.csrf().disable().authorizeRequests().anyRequest().authenticated();
		//Form customizado de login
		http
			.formLogin()
				.loginPage("/login") //url com o retorno do jsp de login
				.defaultSuccessUrl("/") // depois do login vai para onde
				.failureUrl("/login?error=bad_credentials") //se falhar faz o que
			.permitAll(); //permissão total de acesso ao login
        
	}
}
