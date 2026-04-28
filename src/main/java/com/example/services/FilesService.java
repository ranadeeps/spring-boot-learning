package com.example.services;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FilesService {

    public Resource getFile(String fileName) throws  MalformedURLException {
        Path path = Paths.get("src/main/resources/");
        return new UrlResource(path.resolve(fileName).toUri()) ;
    }
}
