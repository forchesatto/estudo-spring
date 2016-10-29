package br.com.camtwo.spring.boot.microservice.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MainEurekaServer {

	public static void main(String[] args) {
		SpringApplication eurekaServer = new SpringApplication(MainEurekaServer.class);
		eurekaServer
		.addListeners(new ApplicationPidFileWriter("eureka-server.pid"));
		eurekaServer.run(args);
	}
}
