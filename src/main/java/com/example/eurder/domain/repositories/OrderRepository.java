package com.example.eurder.domain.repositories;

import com.example.eurder.domain.customer.Customer;
import com.example.eurder.domain.order.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@Repository
public class OrderRepository {
    private final ArrayList<Order> orders = new ArrayList<>();

    public Order addNewOrder(Order order){
        if (! isOrderUnique(order)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The order already placed!");
        }
        orders.add(order);
        return order;
    }

    private boolean isOrderUnique(Order toCheck){
        return !orders.contains(toCheck);
    }


}
