package com.example.eurder.domain.repositories;

import com.example.eurder.domain.customer.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@Repository
public class CustomerRepository {

    private final ArrayList<Customer> customers = new ArrayList<>();

    public Customer addCustomer(Customer customer){
        if (!isCustomerUnique(customer)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The user already exits.");
        }
        customers.add(customer);
        return customer;
    }

    private boolean isCustomerUnique(Customer toCheck){
        return !customers.contains(toCheck);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public Customer getCustomerById(int id) throws RuntimeException{
        return customers.stream().filter(x -> x.getId()==id).findFirst().orElseThrow(RuntimeException::new);
    }
}
