package com.artservicemanipulatingdataservice.artservicemanipulatingdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ArtServiceManipulatingDataServiceApplication
 *
 * This is the service used for manipulating data we have retrieved from the database. The other service is purely
 * for sourcing reference data. This will do things like retrieve images from URLs.
 */
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class ArtServiceManipulatingDataServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ArtServiceManipulatingDataServiceApplication.class, args);
	}
}
