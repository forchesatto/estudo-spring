package br.com.camtwo.spring.jspjpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class TipoProduto {

	@Id
	@GeneratedValue
	private Long codigo;

	@NotEmpty
	@Column(nullable = false)
	private String nome;
	
	public TipoProduto() {

	}

	public TipoProduto(String nome) {
		this.nome = nome;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
