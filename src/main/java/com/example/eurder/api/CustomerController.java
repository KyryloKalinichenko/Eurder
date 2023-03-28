package com.example.eurder.api;

import com.example.eurder.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO){
        return service.createCustomer(customerDTO);
    }

    @GetMapping("all")
    public List<CustomerDTO> getAll(){
        return service.getAllCustomers();
    }

    @GetMapping("{id}")
    public CustomerDTO getById(@PathVariable int id){
        return service.getCustomer(id);
    }
}
