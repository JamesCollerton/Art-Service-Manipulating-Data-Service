package com.artservicemanipulatingdataservice.artservicemanipulatingdataservice.controllers;

import java.util.ArrayList;
import java.util.List;
import io.swagger.annotations.ApiOperation;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.artservicemanipulatingdataservice.artservicemanipulatingdataservice.clients.ArtServiceSourcingDataServiceClient;
import com.artservicemanipulatingdataservice.artservicemanipulatingdataservice.commands.hystrix.commands.GetAllPieceInformationHystrixCommand;

/**
 * This is the controller for requests regarding information around artwork pieces.
 */
@Controller
@RequestMapping("/pieces")
public class PieceInformationController {

    /**
     * Autowired feign sourcing data client
     */
    @Autowired
    private ArtServiceSourcingDataServiceClient artServiceSourcingDataServiceClient;

    /**
     * Autowired hystrix command for circuit breaking
     */
    @Autowired
    private GetAllPieceInformationHystrixCommand getAllPieceInformationHystrixCommand;

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
    public ResponseEntity<List> getAllPieceInformation() throws Exception {

        String allPieceInformationJSONString = getAllPieceInformationHystrixCommand.run();

        new JSONArray(allPieceInformationJSONString);

        return new ResponseEntity<>(new JSONArray(allPieceInformationJSONString).toList(), HttpStatus.OK);

    }

    /**
     * This is the exception handler for the controller
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<List> handleException() {
        return new ResponseEntity<>(new ArrayList(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
