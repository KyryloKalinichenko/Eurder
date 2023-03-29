package com.example.eurder.service.mappers;

import com.example.eurder.api.customer.CustomerDTO;
import com.example.eurder.domain.customer.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {

    public static Customer DTOtoCustomer(CustomerDTO customerDTO){
        return new Customer(customerDTO);
    }

    public static CustomerDTO CustomerToDTO(Customer customer){
        return new CustomerDTO(customer);
    }

    public static List<CustomerDTO> CustomerToDTO(ArrayList<Customer> customers){

        return customers.stream().map(CustomerMapper::CustomerToDTO).collect(Collectors.toList());
    }
}
