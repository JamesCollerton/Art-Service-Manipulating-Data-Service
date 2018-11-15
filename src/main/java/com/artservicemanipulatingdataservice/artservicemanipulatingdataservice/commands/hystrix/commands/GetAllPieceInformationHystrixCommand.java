package com.artservicemanipulatingdataservice.artservicemanipulatingdataservice.commands.hystrix.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.artservicemanipulatingdataservice.artservicemanipulatingdataservice.clients.ArtServiceSourcingDataServiceClient;
import com.artservicemanipulatingdataservice.artservicemanipulatingdataservice.commands.hystrix.setters.ArtServiceTimeoutHystrixSetter;
import com.netflix.hystrix.HystrixCommand;

/**
 * This is a wrapper for calling the sourcing data service with a Hysterix circuit breaker
 */
@Service
public class GetAllPieceInformationHystrixCommand extends HystrixCommand<String> {

    /**
     * Default constructor which passes immediately to the super class using the timeout setter.
     */
    public GetAllPieceInformationHystrixCommand() {
        super(new ArtServiceTimeoutHystrixSetter().get());
    }

    /**
     * Autowired feign sourcing data client
     */
    @Autowired
    private ArtServiceSourcingDataServiceClient artServiceSourcingDataServiceClient;

    /**
     * Method to run the command, now wrapped in the
     *
     * @return
     * @throws Exception
     */
    @Override
    public String run() throws Exception {
        return artServiceSourcingDataServiceClient.getAllPieceInformation();
    }

}
