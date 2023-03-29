package com.example.eurder.api.order;

import com.example.eurder.domain.customer.Customer;
import com.example.eurder.domain.item.ItemGroup;
import com.example.eurder.domain.order.Order;

import java.time.LocalDate;
import java.util.List;

public class OrderGetDTO {

    private List<ItemGroup> itemGroups;
    private Customer owner;

    private double total;


    public OrderGetDTO(List<ItemGroup> itemGroups, Customer owner, double total) {
        this.itemGroups = itemGroups;
        this.owner = owner;
        this.total = total;

    }

    public OrderGetDTO(Order order) {
        this.itemGroups = order.getItemGroups();
        this.owner = order.getOwner();
        this.total = order.getTotal();

    }

    public Customer getOwner() {
        return owner;
    }

    public double getTotal() {
        return total;
    }


    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }


}
