package br.com.camtwo.spring.boot.microservice.produto.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LabelValue {

	private String label;
	private Long value;
}
