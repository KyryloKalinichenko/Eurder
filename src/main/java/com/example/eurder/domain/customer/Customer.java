package com.example.eurder.domain.customer;

import com.example.eurder.api.CustomerDTO;

public class Customer {

    private int id;
    private String firstname;
    private String lastname;
    private Address address;
    private Contact contact;
    private static int counter;


    public Customer(String firstname, String lastname, Address address, Contact contact) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.contact = contact;
        this.address = address;
        id = counter++;
    }

    public Customer(CustomerDTO customerDTO) {
        this.firstname = customerDTO.getFirstname();
        this.lastname = customerDTO.getLastname();
        this.address = customerDTO.getAddress();
        this.contact = customerDTO.getContact();
        id = counter++;
    }

    public Contact getContact() {
        return contact;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }


    public Address getAddress() {
        return address;
    }

}
