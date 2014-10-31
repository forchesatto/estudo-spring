package br.com.camtwo.spring.jsf.controller;

import org.springframework.stereotype.Controller;

@Controller("index")
public class IndexMB {

	private String titulo = "Teste de titulo";
	private String mensagem = "Teste de mensagem";

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
