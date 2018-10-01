package com.artservicemanipulatingdataservice.artservicemanipulatingdataservice.configurations;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * This is the configuration for Eureka.
 */
@Configuration
public class EurekaConfiguration {

    /**
     * Rest Template bean to allow us to use Eureka intelligent service
     * routing.
     *
     * @return New instance of a Rest Template
     */
    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
