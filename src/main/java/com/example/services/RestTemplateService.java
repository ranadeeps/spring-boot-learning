package com.example.services;

import com.example.models.Product;
import com.example.models.ProductDTO;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;

@Service
public class RestTemplateService {
    RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<?> getRequest(){
        return  restTemplate.exchange("https://www.google.com/", HttpMethod.GET,null,String.class);
    }

    public ResponseEntity<Product> postRequest() throws URISyntaxException {
        ProductDTO product = new ProductDTO("bike", new BigDecimal(100));
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        RequestEntity<ProductDTO> requestEntity = new RequestEntity<>(product,httpHeaders,HttpMethod.POST, new URI("http://localhost:8090/crud/create"));
        return  restTemplate.exchange(requestEntity,Product.class);
    }

    public ResponseEntity<Product> putRequest() throws URISyntaxException {
        Product product = new Product(1,"updated",new BigDecimal(10));
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        RequestEntity<Product> requestEntity = new RequestEntity<>(product,httpHeaders,HttpMethod.PUT,new URI("http://localhost:8090/crud/update"));
        return  restTemplate.exchange(requestEntity,Product.class);
    }

}
