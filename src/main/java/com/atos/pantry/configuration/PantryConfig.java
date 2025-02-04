package com.atos.pantry.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class PantryConfig {
    @Value("${pantry.api.base-url}")
    private String baseurl;

    @Bean
    public WebClient webClient() {
        System.out.println("Pantry base API url" + baseurl);
        return WebClient.builder()
                .baseUrl(baseurl)
                .build();

    }

}
