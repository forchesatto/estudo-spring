package br.edu.utfpr.spring.mvc;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/static/**").permitAll();
		
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
