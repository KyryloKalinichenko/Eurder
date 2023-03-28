package com.example.eurder.service;

import com.example.eurder.api.CustomerDTO;
import com.example.eurder.domain.customer.Customer;

public class CustomerMapper {

    static Customer DTOtoCustomer(CustomerDTO customerDTO){
        return new Customer(customerDTO);
    }

    static CustomerDTO CustomerToDTO(Customer customer){
        return new CustomerDTO(customer);
    }
}
