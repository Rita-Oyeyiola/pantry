package com.atos.pantry.service;

import com.atos.pantry.configuration.PantryConfig;
import com.atos.pantry.controller.PantryController;
import com.atos.pantry.model.PantryDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class PantryService {
    private final PantryConfig pantryConfig;

    @Autowired
    public PantryService(WebClient webClient, PantryConfig pantryConfig) {
        this.pantryConfig = pantryConfig;
    }

    public Mono<PantryDetails> getPantryDetails(String pantryId) {
        return pantryConfig.webClient().get()
                .uri("/pantry/" + pantryId)
                .retrieve()
                .bodyToMono(PantryDetails.class);

    }

    public Mono<PantryDetails> updatePantryDetails(String pantryId, PantryDetails pantryDetails) {
        return pantryConfig.webClient().put()
                .uri("/pantry/" + pantryId)
                .bodyValue(pantryDetails)
                .retrieve()
                .bodyToMono(PantryDetails.class);
    }

}
