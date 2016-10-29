package br.com.camtwo.spring.boot.microservice.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "nome")
public class TipoProduto {

	private Long codigo;

	private String nome;
	
	private Double valorMinimo;
}
