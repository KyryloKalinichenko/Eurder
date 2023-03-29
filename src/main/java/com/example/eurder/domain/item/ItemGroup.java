package com.example.eurder.domain.item;

import com.example.eurder.api.item.ItemGroupPostDTO;
import com.example.eurder.domain.item.Item;

import java.time.LocalDate;
import java.util.ArrayList;

public class ItemGroup {
    private Item item;
    private int amount;
    private double total;
    private LocalDate shippingDate;

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public ItemGroup(Item item, int amount, LocalDate shippingDate) {
        this.item = item;
        this.amount = amount;
        this.total = amount * item.getPrice();
        this.shippingDate = shippingDate;
    }

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }

    public double getTotal() {
        return total;
    }
}
