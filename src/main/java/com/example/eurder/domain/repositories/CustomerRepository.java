package com.example.eurder.domain.repositories;

import com.example.eurder.domain.customer.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class CustomerRepository {

    private ArrayList<Customer> customers = new ArrayList<>();

    public Customer addCustomer(Customer customer){
        customers.add(customer);
        return customer;
    }
}
