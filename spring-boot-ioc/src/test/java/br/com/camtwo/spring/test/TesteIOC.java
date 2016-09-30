package br.com.camtwo.spring.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.camtwo.spring.ioc.Main;
import br.com.camtwo.spring.ioc.domain.CalculoImposto;
import br.com.camtwo.spring.ioc.domain.CalculoImpostoPR;
import br.com.camtwo.spring.ioc.domain.CalculoImpostoSC;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class TesteIOC {

	@Autowired
	@Qualifier("sc")
	private CalculoImposto calculaImpostoSC;
	
	@Autowired
	@Qualifier("pr")
	private CalculoImposto calculaImpostoPR;
	
	@Test
	public void deveSerInstanciaSC(){
		assertTrue(calculaImpostoSC instanceof CalculoImpostoSC);
	}
	
	@Test
	public void deveSerInstanciaPR(){
		assertTrue(calculaImpostoPR instanceof CalculoImpostoPR);
	}

	@Test
	public void deveCalcularImpostoSC(){
		Double valorImposto = calculaImpostoSC.calculaImposto(100.0);
		assertEquals(Double.valueOf(14.8), valorImposto);
	}
	
	@Test
	public void deveCalcularImpostoPR(){
		Double valorImposto = calculaImpostoPR.calculaImposto(100.0);
		assertEquals(Double.valueOf(7.30), valorImposto);
	}
}
