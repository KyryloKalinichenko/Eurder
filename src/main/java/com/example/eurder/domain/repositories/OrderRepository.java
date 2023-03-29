package com.example.eurder.domain.repositories;

import com.example.eurder.domain.customer.Customer;
import com.example.eurder.domain.order.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class OrderRepository {
    private final ArrayList<Order> orders = new ArrayList<>();

    public Order addNewOrder(Order order){

        /// TODO Validate uniqueness
        orders.add(order);
        return order;
    }


}
