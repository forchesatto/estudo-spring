package br.edu.utfpr.spring.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class MainServer extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MainServer.class, args);
	}
	
	@Bean
	public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter(){
		return new WebSecurityConfig();
	}
	
}
