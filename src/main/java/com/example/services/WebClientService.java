package com.example.services;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class WebClientService {
    public ResponseEntity<?> getRequest() throws URISyntaxException {
        WebClient webClient = WebClient.create();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.TEXT_HTML);
        String s = webClient.get().uri(new URI("https://www.google.com/")).exchangeToMono((clientResponse -> {
            return clientResponse.bodyToMono(String.class);
        })).block();
        return new ResponseEntity<>(s, httpHeaders, HttpStatus.OK);
    }
}
