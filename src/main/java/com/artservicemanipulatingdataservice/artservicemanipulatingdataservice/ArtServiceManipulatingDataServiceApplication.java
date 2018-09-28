package com.artservicemanipulatingdataservice.artservicemanipulatingdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/*
TODO: Comments
TODO: Swagger
TODO: Testing
TODO: Docker
 */
@SpringBootApplication
@EnableEurekaClient
public class ArtServiceManipulatingDataServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ArtServiceManipulatingDataServiceApplication.class, args);
	}
}
