package com.example.controllers;

import com.example.services.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FilesService filesService;

    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> getFile(@PathVariable String fileName) throws MalformedURLException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.TEXT_PLAIN);
        httpHeaders.setContentDisposition(ContentDisposition.builder("attachment").build());
        return new ResponseEntity<>(filesService.getFile(fileName),httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/view/{fileName}")
    public ResponseEntity<Resource> viewFile(@PathVariable String fileName) throws MalformedURLException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.TEXT_PLAIN);
        httpHeaders.setContentDisposition(ContentDisposition.builder("inline").build());
        return new ResponseEntity<>(filesService.getFile(fileName),httpHeaders, HttpStatus.OK);
    }
}
