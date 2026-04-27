package com.example.controllers;

import com.example.models.Product;
import com.example.services.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/rest-template")
public class RestTemplateController {

    @Autowired
    private RestTemplateService restTemplateService;

    @GetMapping("/get-request")
    public ResponseEntity<?> getRequest(){
        return  restTemplateService.getRequest();
    }

    @GetMapping("/post-request")
    public ResponseEntity<Product> postRequest() throws Exception{
        return  restTemplateService.postRequest();
    }

    @GetMapping("/put-request")
    public ResponseEntity<Product> putRequest() throws URISyntaxException {
        return restTemplateService.putRequest();
    }

}
