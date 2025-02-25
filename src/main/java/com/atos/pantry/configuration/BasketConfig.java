package com.atos.pantry.configuration;

import io.netty.handler.logging.LogLevel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.logging.AdvancedByteBufFormat;

@Configuration
@Slf4j
public class BasketConfig {
    private final PantryProperties pantryProperties;

    public BasketConfig(PantryProperties pantryProperties) {
        this.pantryProperties = pantryProperties;
    }

    @Bean
    public WebClient webClient() {
        HttpClient httpClient = HttpClient.create().wiretap("reactor.netty.http.client.HttpClient", LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL);
        log.info("Base URL ::: {}", pantryProperties.getBaseUrl());
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(pantryProperties.getBaseUrl())
                .build();
    }
}
