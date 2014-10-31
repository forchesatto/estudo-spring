package br.com.camtwo.spring.jsf.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.camtwo.spring.jsf.service.IndexService;

@Controller("index")
public class IndexMB {

	private String titulo = "Teste de titulo";
	
	@Autowired
	private IndexService indexService;
	
	@PostConstruct
	public void init(){
		titulo = "Teste de titulo";
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return indexService.mensagem();
	}

}
