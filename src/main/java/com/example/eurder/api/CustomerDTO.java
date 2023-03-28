package com.example.eurder.api;

import com.example.eurder.domain.address.Address;
import com.example.eurder.domain.customer.Customer;

public class CustomerDTO {

    private String firstname;
    private String lastname;
    private String email;
    private Address address;
    private String phoneNumber;

    public CustomerDTO(String firstname, String lastname, String email, Address address, String phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public CustomerDTO(Customer customer) {
        this.firstname = customer.getFirstname();
        this.lastname = customer.getLastname();
        this.email = customer.getEmail();
        this.address = customer.getAddress();
        this.phoneNumber = customer.getPhoneNumber();
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
