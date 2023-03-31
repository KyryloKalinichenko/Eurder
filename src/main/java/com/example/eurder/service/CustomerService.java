package com.example.eurder.service;

import com.example.eurder.api.customer.CustomerDTO;
import com.example.eurder.domain.repositories.CustomerRepository;
import com.example.eurder.service.mappers.CustomerMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public List<CustomerDTO> getAllCustomers(String token) {
        tokenVerification(token);
        return CustomerMapper.CustomerToDTO(repository.getCustomers());
    }

    private static void tokenVerification(String token) {
        if (token == null || !token.equals("admin")){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied!");
        }
    }

    public CustomerDTO getCustomer(int id, String token) {
        tokenVerification(token);
        try {
            return CustomerMapper.CustomerToDTO(repository.getCustomerById(id));
        } catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
        }
    }
}
