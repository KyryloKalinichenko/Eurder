package com.example.eurder.domain.item;

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
}
