package com.example.eurder.service;

import com.example.eurder.api.CustomerDTO;
import com.example.eurder.domain.repositories.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO){
        return CustomerMapper.CustomerToDTO(repository.addCustomer(CustomerMapper.DTOtoCustomer(customerDTO)));
    }

    public List<CustomerDTO> getAllCustomers() {
        return CustomerMapper.CustomerToDTO(repository.getCustomers());
    }

    public CustomerDTO getCustomer(int id) {
        try {
            return CustomerMapper.CustomerToDTO(repository.getCustomerById(id));
        } catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
        }
    }
}
