package com.java.helloworld.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    private String name;
    public String getInfo() {
        return getName();
    }
}
