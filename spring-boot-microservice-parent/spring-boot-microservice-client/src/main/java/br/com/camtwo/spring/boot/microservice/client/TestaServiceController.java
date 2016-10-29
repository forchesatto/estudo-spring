package br.com.camtwo.spring.boot.microservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.camtwo.spring.boot.microservice.model.TipoProduto;

@RestController
@RequestMapping("/testaService")
public class TestaServiceController {

	
	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;
	
	@GetMapping("/tipoProduto")
	public TipoProduto getTipoProduto(){
		return restTemplate
				.getForObject("http://produto-service/tipoProduto/10", 
						TipoProduto.class);
	}
}
