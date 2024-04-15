package com.java.helloworld.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public AppConfig appConfig() {
        return new AppConfig();
    }

}
