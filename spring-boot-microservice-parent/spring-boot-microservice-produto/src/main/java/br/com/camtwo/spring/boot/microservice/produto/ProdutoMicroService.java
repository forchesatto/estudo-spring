package br.com.camtwo.spring.boot.microservice.produto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProdutoMicroService {

	 public static void main(String[] args) {
	        SpringApplication notificationMicroService = new SpringApplication(ProdutoMicroService.class);
	        notificationMicroService
	        .addListeners(new ApplicationPidFileWriter
	        								("produto-micro-service.pid"));
	        notificationMicroService.run(args);
	    }
}
