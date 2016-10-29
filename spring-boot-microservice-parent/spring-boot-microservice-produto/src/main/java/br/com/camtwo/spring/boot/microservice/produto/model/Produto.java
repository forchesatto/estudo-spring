package br.com.camtwo.spring.boot.microservice.produto.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@NamedEntityGraphs(@NamedEntityGraph(name = "Produto.tipoProduto",
	attributeNodes=@NamedAttributeNode("tipoProduto")))
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@NotEmpty
	private String nome;

	private Double valor;

	@ManyToOne(fetch = FetchType.LAZY)
	private TipoProduto tipoProduto;
}
