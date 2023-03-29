package com.example.eurder.service.mappers;

import com.example.eurder.api.order.OrderGetDTO;
import com.example.eurder.api.order.OrderPostDTO;
import com.example.eurder.domain.customer.Customer;
import com.example.eurder.domain.order.Order;

import java.time.LocalDate;

public class OrderMapper {
    /*
        TODO

        Order -> GetDTO
    */



    public static OrderGetDTO fromOrderToGetDTO(Order order){
        return new OrderGetDTO(order);
    }
}
