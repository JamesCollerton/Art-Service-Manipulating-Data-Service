package com.artservicemanipulatingdataservice.artservicemanipulatingdataservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("art-service-sourcing-data-service")
public interface ArtServiceSourcingDataServiceClient {
    @RequestMapping(method = RequestMethod.GET, value = "/pieces", consumes = "application/json")
    String getAllPieceInformation();
}
