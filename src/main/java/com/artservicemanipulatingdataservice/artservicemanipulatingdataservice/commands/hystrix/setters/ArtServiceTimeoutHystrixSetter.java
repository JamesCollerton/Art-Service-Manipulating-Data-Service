package com.artservicemanipulatingdataservice.artservicemanipulatingdataservice.commands.hystrix.setters;

import java.util.function.Supplier;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

/**
 * This is a wrapper class for the setters for the Hystrix commands. This one is used to allow a 10,000 millisecond
 * timeout.
 */
public class ArtServiceTimeoutHystrixSetter implements Supplier<HystrixCommand.Setter> {

    /**
     * This is used to return a config with the max milliseconds to 10,000
     *
     * @return Returns a full hystrix configuration with the required timeout set.
     */
    @Override
    public HystrixCommand.Setter get() {

        HystrixCommand.Setter config = HystrixCommand
                .Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("ArtServiceTimeoutHystrixSetter"));

        HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter();
        commandProperties.withExecutionTimeoutInMilliseconds(10000);
        config.andCommandPropertiesDefaults(commandProperties);

        return config;

    }
}
