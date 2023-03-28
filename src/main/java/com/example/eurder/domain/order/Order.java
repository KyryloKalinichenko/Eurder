package com.example.eurder.domain.order;

import com.example.eurder.domain.customer.Customer;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private List<ItemGroup> itemGroups;
    private LocalDate shippingDate;
    private Customer owner;
    private double total;

    public Order(List<ItemGroup> itemGroups, LocalDate shippingDate, Customer owner, double total) {
        this.itemGroups = itemGroups;
        this.shippingDate = shippingDate;
        this.owner = owner;
        this.total = total;
    }
}
