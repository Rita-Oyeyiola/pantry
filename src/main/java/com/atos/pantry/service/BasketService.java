package com.atos.pantry.service;

import com.atos.pantry.model.Basket;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class BasketService {
    public final WebClient webClient;

    public BasketService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.yourpantry.com").build();
    }

    public Flux<Basket> getBasketsByPantryId (String pantryId) {
        return webClient.get()
                .uri("/pantry/{pantryId}/basket", pantryId)
                .retrieve()
                .bodyToFlux(Basket.class);
    }

    public Mono<Basket> createBasket(Basket basket) {
        return webClient.post()
                .uri("/pantry/pantryId/basket/{basketName}", basket.getPantryId(), basket.getName())
                .bodyValue(basket)
                .retrieve()
                .bodyToMono(Basket.class);
    }

    public Mono<Basket> updateBasket(String id, Basket basket) {
        return webClient.put()
                .uri("/pantry/pantryId/basket/{basketName}", basket.getPantryId(), basket.getName())
                .bodyValue(basket)
                .retrieve()
                .bodyToMono(Basket.class);
    }

    public Mono<Void> deleteBasket(String pantryId, String basketName) {
        return webClient.delete()
                .uri("/pantry/{pantryId}/basket/{basketName}")
                .retrieve()
                .bodyToMono(Void.class);

    }

}
