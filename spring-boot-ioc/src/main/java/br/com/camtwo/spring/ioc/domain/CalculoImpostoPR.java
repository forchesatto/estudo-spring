package br.com.camtwo.spring.ioc.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("pr")
public class CalculoImpostoPR implements CalculoImposto {

	@Value("${imposto.pr}")
	private Double taxaImposto;
	
	@Override
	public Double calculaImposto(Double valorMercadoria) {
		return valorMercadoria * (taxaImposto/100);
	}

}
