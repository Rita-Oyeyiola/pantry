package com.atos.pantry.controller;

import com.atos.pantry.model.Basket;
import com.atos.pantry.service.BasketService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping
@RestController ("/pantry/{pantryId}/basket")
public class BasketController {
    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping
    public Flux<Basket> getBasket(@PathVariable String pantryId) {
        return basketService.getBasketsByPantryId(pantryId);

    }

    @PostMapping
    public Mono<Basket> createBasket(@RequestBody Basket basket) {
        return basketService.createBasket(basket);
    }

    @PutMapping ("/{id}")
    public Mono<Basket> updateBasket(@PathVariable String id, @RequestBody Basket basket) {
        return basketService.updateBasket(id, basket);
    }

    @DeleteMapping ("/{id}")
    public Mono<Void> deleteBasket(@PathVariable String pantryId, @PathVariable String basketName) {
        return basketService.deleteBasket(pantryId, basketName);

    }


}
