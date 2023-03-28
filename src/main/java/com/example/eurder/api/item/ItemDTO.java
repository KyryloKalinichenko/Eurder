package com.example.eurder.api.item;

import com.example.eurder.domain.item.Item;

public class ItemDTO {
    private String name;
    private String description;
    private double price;

    public ItemDTO(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ItemDTO(Item item) {
        this.name = item.getName();
        this.price = item.getPrice();
        this.description = item.getDescription();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}
