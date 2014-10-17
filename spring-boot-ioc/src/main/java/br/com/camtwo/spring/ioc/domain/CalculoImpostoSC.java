package br.com.camtwo.spring.ioc.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("sc")
public class CalculoImpostoSC implements CalculoImposto {

	@Value("${imposto.sc}")
	private Double taxaImposto;
	
	@Value("${taxaAdicional}")
	private Double taxaAdicional;
	
	@Override
	public Double calculaImposto(Double valorMercadoria) {
		return (valorMercadoria * (taxaImposto/100)) + taxaAdicional;
	}

}
