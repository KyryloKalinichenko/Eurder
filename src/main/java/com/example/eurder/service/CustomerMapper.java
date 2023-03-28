package com.example.eurder.service;

import com.example.eurder.api.customer.CustomerDTO;
import com.example.eurder.domain.customer.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {

    static Customer DTOtoCustomer(CustomerDTO customerDTO){
        return new Customer(customerDTO);
    }

    static CustomerDTO CustomerToDTO(Customer customer){
        return new CustomerDTO(customer);
    }

    static List<CustomerDTO> CustomerToDTO(ArrayList<Customer> customers){

        return customers.stream().map(CustomerMapper::CustomerToDTO).collect(Collectors.toList());
    }
}
