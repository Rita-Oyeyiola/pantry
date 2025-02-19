package com.atos.pantry.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("pantry")
@Configuration
@Data
public class PantryProperties {
    private String baseUrl;
    private String id;

}
