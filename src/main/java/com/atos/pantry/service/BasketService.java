package com.atos.pantry.service;

import com.atos.pantry.configuration.PantryConfig;
import com.atos.pantry.model.Basket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BasketService {

    public final PantryConfig pantryConfig;
    @Autowired
    public BasketService(PantryConfig pantryConfig) {
        this.pantryConfig = pantryConfig;
    }

    public Flux<Basket> getBasketsByPantryId (String pantryId) {
        return this.pantryConfig.webClient().get()
                .uri("/pantry/{pantryId}/basket", pantryId)
                .retrieve()
                .bodyToFlux(Basket.class);
    }

    public Mono<Basket> createBasket(Basket basket) {
        return this.pantryConfig.webClient().post()
                .uri("/pantry/pantryId/basket/{basketName}", basket.getPantryId(), basket.getName())
                .bodyValue(basket)
                .retrieve()
                .bodyToMono(Basket.class);
    }

    public Mono<Basket> updateBasket(String id, Basket basket) {
        return this.pantryConfig.webClient().put()
                .uri("/pantry/pantryId/basket/{basketName}", basket.getPantryId(), basket.getName())
                .bodyValue(basket)
                .retrieve()
                .bodyToMono(Basket.class);
    }

    public Mono<Void> deleteBasket(String pantryId, String basketName) {
        return this.pantryConfig.webClient().delete()
                .uri("/pantry/{pantryId}/basket/{basketName}")
                .retrieve()
                .bodyToMono(Void.class);

    }

}
