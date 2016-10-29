package br.com.camtwo.spring.boot.microservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.camtwo.spring.boot.microservice.model.TipoProduto;

@SpringBootApplication
@EnableDiscoveryClient
public class MainClient extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MainClient.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder 
			builder) {
		return builder.sources(MainClient.class);
	}
	

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}

@RestController
@RequestMapping("/testaService")
class RestTemplateExample {

	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;
	
	@GetMapping("/tipoProduto")
	public TipoProduto getTipoProduto(){
		return restTemplate.getForObject("http://produto-service/tipoProduto/10", TipoProduto.class);
	}

//	@Override
//	public void run(String... strings) throws Exception {
//		TipoProduto tipoProduto = restTemplate.getForObject("http://produto-service/tipoProduto/10", TipoProduto.class);
//		System.out.println(tipoProduto.getNome());
//
//		// use the "smart" Eureka-aware RestTemplate
//		// ResponseEntity<List<Bookmark>> exchange =
//		// this.restTemplate.exchange(
//		// "http://produto-service/tipoProduto/1",
//		// HttpMethod.GET,
//		// null,
//		// new ParameterizedTypeReference<List<Bookmark>>() {
//		// },
//		// (Object) "mstine");
//		//
//		// exchange.getBody().forEach(System.out::println);
//	}

}
