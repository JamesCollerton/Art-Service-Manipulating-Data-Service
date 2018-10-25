package com.artservicemanipulatingdataservice.artservicemanipulatingdataservice.controllers;

import java.util.List;
import io.swagger.annotations.ApiOperation;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import com.artservicemanipulatingdataservice.artservicemanipulatingdataservice.clients.ArtServiceSourcingDataServiceClient;
import com.fasterxml.jackson.databind.util.JSONPObject;

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
     * Autowired feign sourcing data client
     */
    @Autowired
    private ArtServiceSourcingDataServiceClient artServiceSourcingDataServiceClient;

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
            response = List.class,
            produces = "application/json"
    )
    @GetMapping
    public ResponseEntity<List> getAllPieceInformation() {

        String allPieceInformationJSONString = artServiceSourcingDataServiceClient.getAllPieceInformation();

        new JSONArray(allPieceInformationJSONString);

        return new ResponseEntity<>(new JSONArray(allPieceInformationJSONString).toList(), HttpStatus.OK);

    }

}
