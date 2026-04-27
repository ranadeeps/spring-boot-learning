package com.example.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class GetController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello world / Get";
    }

    @GetMapping("/path-1/{variable}")
    public String pathParam(@PathVariable String variable) {
        return variable;
    }

    @GetMapping("/path-2/{variable}/path/{variable2}")
    public String pathParam(@PathVariable String variable, @PathVariable String variable2) {
        return variable + "/" + variable2;
    }

    @GetMapping("/query")
    public String queryParam(@RequestParam String name) {
        return name;
    }

    @GetMapping("/multiquery-part-1")
    public String queryParam(@RequestParam List<String> name) {
        return name.toString();
    }

    @GetMapping("/multiquery-part-2")
    public String queryParam(@RequestParam Map<String, String> name) {
        return name.toString();
    }
}
