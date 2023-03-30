package com.example.eurder.domain.item;

import java.util.Objects;

public class Item {
    private int id;
    private String name;
    private String description;
    private double price;
    private int amount;
    private static int counter;

    public int getId() {
        return id;
    }

    public Item(String name, String description, double price, int amount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
        id = counter++;
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

    public int getAmount() {
        return amount;
    }

    public void decriesStock(int itemsOrdered){
        if (itemsOrdered > amount){
            amount = 0;
            return ;
        }
        amount -= itemsOrdered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return name.equals(item.name) && description.equals(item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, price);
    }
}
