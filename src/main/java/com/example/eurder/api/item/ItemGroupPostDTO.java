package com.example.eurder.api.item;

public class ItemGroupPostDTO {
    private int itemId;
    private int amount;

    public ItemGroupPostDTO(int itemId, int amount) {
        this.itemId = itemId;
        this.amount = amount;
    }

    public int getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }
}
