package com.atos.pantry.controller;

import com.atos.pantry.model.PantryDetails;
import com.atos.pantry.service.PantryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api/pantry")
public class PantryController {

    private final PantryService pantryService;


    public PantryController(PantryService pantryService) {
        this.pantryService = pantryService;
    }

    @GetMapping
    public PantryDetails getPantryDetails() {
        return pantryService.getPantryDetails();
    }

    @PutMapping
    public void updatePantryDetails(@RequestBody PantryDetails pantryDetails) {
       pantryService.updatePantryDetails(pantryDetails);
    }
}
