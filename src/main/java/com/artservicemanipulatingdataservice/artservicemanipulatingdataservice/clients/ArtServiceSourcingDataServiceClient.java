package com.artservicemanipulatingdataservice.artservicemanipulatingdataservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("spring-cloud-eureka-client")
public interface ArtServiceSourcingDataServiceClient {
    @RequestMapping("/pieces")
    String getAllPieceInformation();
}
