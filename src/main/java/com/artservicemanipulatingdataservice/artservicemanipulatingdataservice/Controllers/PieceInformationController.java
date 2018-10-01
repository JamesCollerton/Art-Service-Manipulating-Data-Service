package com.artservicemanipulatingdataservice.artservicemanipulatingdataservice.Controllers;

import java.util.ArrayList;
import java.util.List;
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

@Controller
@RequestMapping("/pieces")
public class PieceInformationController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<String> getAllPieceInformation() {

        String allPieceInformationJSONString =
                restTemplate.getForObject("http://art-service-sourcing-data-service-application/pieces", String.class);

        return new ResponseEntity<>(allPieceInformationJSONString, HttpStatus.OK);
    }

}
