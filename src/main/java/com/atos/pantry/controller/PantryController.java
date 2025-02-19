package com.atos.pantry.controller;

import com.atos.pantry.model.PantryDetails;
import com.atos.pantry.service.PantryService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping ("/api/pantry")
public class PantryController {
   private final PantryService pantryService;

    public PantryController(PantryService pantryService) {
        this.pantryService = pantryService;
    }

    @GetMapping("{pantryId}")
    public Mono<PantryDetails> getPantryDetails(@PathVariable String pantryId) {
        return pantryService.getPantryDetails(pantryId);
    }

    @PutMapping("{pantryId}")
    public Mono<PantryDetails> updatePantryDetails(@PathVariable String pantryId, @RequestBody PantryDetails pantryDetails) {
        return pantryService.updatePantryDetails(pantryId, pantryDetails);
    }
}
