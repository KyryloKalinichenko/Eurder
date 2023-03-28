package com.example.eurder.domain.customer;

import com.example.eurder.api.CustomerDTO;
import com.example.eurder.domain.address.Address;

public class Customer {

    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private Address address;
    private String phoneNumber;
    private static int counter;

    public Customer(String firstname, String lastname, String email, Address address, String phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        id = counter++;
    }

    public Customer(CustomerDTO customerDTO) {
        this.firstname = customerDTO.getFirstname();
        this.lastname = customerDTO.getLastname();
        this.email = customerDTO.getEmail();
        this.address = customerDTO.getAddress();
        this.phoneNumber = customerDTO.getPhoneNumber();
        id = counter++;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
