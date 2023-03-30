package com.example.eurder.api.order;

import com.example.eurder.service.CustomerService;
import com.example.eurder.service.OrderService;
import jdk.jfr.ContentType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("order")
public class OrderController {

    private OrderService service;
    private CustomerService customerService;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderGetDTO newOrder(@RequestBody OrderPostDTO postDTO, @RequestHeader int customerId){


        return service.submitNewOrder(postDTO, customerId);

    }
}
