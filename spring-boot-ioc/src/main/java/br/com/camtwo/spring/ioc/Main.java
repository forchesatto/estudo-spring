package br.com.camtwo.spring.ioc;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.camtwo.spring.ioc.domain.CalculoImposto;

@SpringBootApplication
public class Main implements CommandLineRunner {

	@Autowired
	@Qualifier("pr")
	private CalculoImposto calculoImposto;

	public static void main(String[] valores) throws Exception {
		SpringApplication.run(Main.class, valores);
	}

	@Override
	public void run(String... valores) throws Exception {
		List<String> valoresCalcula = Arrays.asList(valores);
		valoresCalcula.forEach(v -> printValor(calculoImposto
				.calculaImposto(Double.valueOf(v))));
	}

	private void printValor(Double valor) {
		System.out.println("Valor do imposto: " + valor);
	}
}
