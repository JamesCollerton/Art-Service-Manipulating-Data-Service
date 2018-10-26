package com.artservicemanipulatingdataservice.artservicemanipulatingdataservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This is the Feign client for interacting with the sourcing data service.
 */
@FeignClient("art-service-sourcing-data-service")
public interface ArtServiceSourcingDataServiceClient {

    /**
     * Responsible for retrieving all piece information from the sourcing data service
     *
     * @return Returns a string representing JSON of piece information
     */
    @RequestMapping(method = RequestMethod.GET, value = "/pieces", consumes = "application/json")
    String getAllPieceInformation();
}
