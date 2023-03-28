package com.example.eurder.service;

import com.example.eurder.api.CustomerDTO;
import com.example.eurder.domain.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO){
        return CustomerMapper.CustomerToDTO(repository.addCustomer(CustomerMapper.DTOtoCustomer(customerDTO)));
    }
}
