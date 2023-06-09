package com.example.eurder.domain.order;

import com.example.eurder.api.order.OrderPostDTO;
import com.example.eurder.domain.customer.Customer;
import com.example.eurder.domain.item.ItemGroup;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<ItemGroup> itemGroups;
    private Customer owner;
    private double total;

    public Order(List<ItemGroup> itemGroups, Customer owner, double total) {
        this.itemGroups = itemGroups;
        this.owner = owner;
        this.total = total;
    }


    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }


    public Customer getOwner() {
        return owner;
    }

    public double getTotal() {
        return total;
    }
}
