package com.atos.pantry.model;

import lombok.Data;

@Data
public class Basket {
    private String name;
    private String id;
    private String pantryId;
    private String contents;

}
