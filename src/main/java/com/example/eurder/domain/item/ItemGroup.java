package com.example.eurder.domain.item;

import java.time.LocalDate;

public class ItemGroup {
    private Item item;
    private int amount;
    private LocalDate shippingDate;

    public static final int DELAY_WHEN_OUT_OF_STOCK = 7;
    public static final int NORMAL_DELAY = 1;

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public ItemGroup(Item item, int amount) {
        if (item == null || amount < 1)
        {
            throw new IllegalArgumentException("Item cannot be null and amount should be bigger that 0");
        }

        this.item = item;
        this.amount = amount;
        this.shippingDate = calculateShipping();
    }

    private LocalDate calculateShipping() {
        if (item.getAmount() < amount){
            return LocalDate.now().plusDays(DELAY_WHEN_OUT_OF_STOCK);
        }
        return LocalDate.now().plusDays(NORMAL_DELAY);
    }

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }

    public double getTotalPrice() {
        return amount * item.getPrice();
    }
}
