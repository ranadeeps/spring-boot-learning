package com.example.controllers;

import com.example.models.Basic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @PostMapping(value = "/", produces = "text/xml")
    public String helloWorld() {
        return "Hello world / Post";
    }

    @PostMapping("/body")
    public Basic body(@RequestBody Basic body) {
        System.out.println(body.toString());
        return body;
    }

}
