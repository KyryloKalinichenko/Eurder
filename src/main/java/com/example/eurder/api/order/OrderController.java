package com.example.eurder.api.order;

import com.example.eurder.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {

    private OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderGetDTO newOrder(@RequestBody OrderPostDTO getDTO){
        return service.submitNewOrder(getDTO);

    }
}
