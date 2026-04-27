package com.example.controllers;

import com.example.services.WebClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/web-client")
public class WebClientController {

    @Autowired
    private WebClientService webClientService;

    @GetMapping("/get-request")
    public ResponseEntity<?> getRequest() throws URISyntaxException {
        return webClientService.getRequest();
    }

}
