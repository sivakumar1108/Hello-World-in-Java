package com.java.helloworld.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController("/")
public class Controller {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @GetMapping("/")
    public static ResponseEntity<String> getHelloWorld() {
        logger.info("New Request TimeStamp :: {}", LocalDateTime.now());
        return ResponseEntity.ok().body("Hello World");
    }
}
