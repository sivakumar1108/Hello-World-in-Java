package com.java.helloworld.controller;

import com.java.helloworld.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController("/")
public class Controller {

    private AppConfig appConfig;

    public Controller(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @GetMapping("/")
    public ResponseEntity<String> getHelloWorld() {
        logger.info("Controller :: getHelloWorld :: TimeStamp :: {}", LocalDateTime.now());
        return ResponseEntity.ok().body("Hello");
    }

    /*Get App info*/
    @GetMapping("/app")
    public ResponseEntity<String> getAppInfo() {
        String result = appConfig.getInfo();
        logger.info("Controller :: getAppInfo ::Info :: '{}'",result);
        return ResponseEntity.ok().body(result);
    }

}
