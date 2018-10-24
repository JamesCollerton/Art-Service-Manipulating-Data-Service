package com.artservicemanipulatingdataservice.artservicemanipulatingdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
TODO: Comments
TODO: Swagger
TODO: Testing
TODO: Docker
 */
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class ArtServiceManipulatingDataServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ArtServiceManipulatingDataServiceApplication.class, args);
	}
}
