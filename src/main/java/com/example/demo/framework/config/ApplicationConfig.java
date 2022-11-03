package com.example.demo.framework.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "application")
public class ApplicationConfig {
    private Cors cors = new Cors();

    @Getter
    @Setter
    public static class Cors {
        private boolean enable = true;
        @Value("#{'${application.cors.allowed-origins}'.split(',')}")
        private List<String> allowedOrigins;
        @Value("#{'${application.cors.allowed-headers}'.split(',')}")
        private List<String> allowedHeaders;
        @Value("#{'${application.cors.allowed-methods}'.split(',')}")
        private List<String> allowedMethods;
        private Boolean allowCredentials;
        private Long maxAge;
    }
}

