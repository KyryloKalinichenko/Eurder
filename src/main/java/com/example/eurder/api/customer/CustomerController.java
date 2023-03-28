package com.example.eurder.api.customer;

import com.example.eurder.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public List<CustomerDTO> getAll(@RequestHeader String token){
        return service.getAllCustomers(token);
    }

    @GetMapping("{id}")
    public CustomerDTO getById(@PathVariable int id, @RequestHeader String token){
        return service.getCustomer(id, token);
    }
}
