package com.artservicemanipulatingdataservice.artservicemanipulatingdataservice.Controllers;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;

/**
 * This is the controller for requests regarding information around artwork pieces.
 */
@Controller
@RequestMapping("/pieces")
public class PieceInformationController {

    /**
     * Autowired rest template to allow us to use Eureka intelligent routing.
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * End point for getting all of the piece information from the sourcing data service. Does
     * not deserialize the result as no manipulation is needed.
     *
     * @return A JSON string of all piece information
     */
    @ApiOperation(
            httpMethod = "GET",
            value = "Gets all information around artwork pieces",
            notes = "Returns a list of piece information for all artwork in the collection.",
            response = String.class
    )
    @GetMapping
    public ResponseEntity<String> getAllPieceInformation() {

        String allPieceInformationJSONString =
                restTemplate.getForObject("http://art-service-sourcing-data-service-application/pieces", String.class);

        return new ResponseEntity<>(allPieceInformationJSONString, HttpStatus.OK);
    }

}
