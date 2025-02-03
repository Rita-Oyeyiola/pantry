package com.atos.pantry.service;

import com.atos.pantry.model.PantryDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PantryService {
    @Value("${pantry.api.path}")
    private String pantryApiPath;

    @Value("${pantry.id}")
    private String pantryId;

    private final RestTemplate restTemplate;

    @Autowired
    public PantryService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public PantryDetails getPantryDetails() {
        String url = pantryApiPath + "/pantry/" + pantryId;
        return restTemplate.getForObject(url, PantryDetails.class);
    }

    public void updatePantryDetails(PantryDetails pantryDetails) {
        String url = pantryApiPath + "/pantry/" + pantryId;
        restTemplate.put(url, pantryDetails);
    }

}
