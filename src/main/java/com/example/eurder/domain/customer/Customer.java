package com.example.eurder.domain.customer;

import com.example.eurder.api.customer.CustomerDTO;
import com.example.eurder.domain.user.User;

import java.util.Objects;

public class Customer extends User {


    private Address address;
    private Contact contact;


    public Customer(String firstname, String lastname, Address address, Contact contact) {
        super(firstname, lastname);
        this.contact = contact;
        this.address = address;

    }

    public Customer(CustomerDTO customerDTO) {
        super(customerDTO.getFirstname(), customerDTO.getLastname());
        this.address = customerDTO.getAddress();
        this.contact = customerDTO.getContact();
    }

    public Contact getContact() {
        return contact;
    }


    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return address.equals(customer.address) && contact.equals(customer.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, contact);
    }
}
