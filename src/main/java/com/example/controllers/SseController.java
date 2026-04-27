package com.example.controllers;

import com.example.others.Sse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@RestController
public class SseController {

    @GetMapping(value = "/sse",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter sseEmitter() throws IOException {
        return Sse.INSTANCE.getEmitter();
    }

    @GetMapping("/test-sse")
    public String testSse() throws IOException {
        Sse.INSTANCE.getEmitter().send("Hello World");
        return "event sent";
    }


}
