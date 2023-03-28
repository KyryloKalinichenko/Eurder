package com.example.eurder.domain.order;

import com.example.eurder.domain.item.Item;

public class ItemGroup {
    private Item item;
    private int amount;

    public ItemGroup(Item item, int amount) {
        this.item = item;
        this.amount = amount;
    }

}
