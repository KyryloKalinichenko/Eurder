package com.example.eurder.api.customer;

import com.example.eurder.domain.customer.Address;
import com.example.eurder.domain.customer.Contact;
import com.example.eurder.domain.customer.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class CustomerDTO {

    private String firstname;
    private String lastname;
    private Address address;
    private Contact contact;

    public CustomerDTO(String firstname, String lastname, Contact contact, Address address) {
        if (firstname == null || lastname == null
                || contact == null || address == null){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "First and lastnames should be filled.");
        }
        this.firstname = firstname;
        this.lastname = lastname;
        this.contact = contact;
        this.address = address;

    }

    public CustomerDTO(Customer customer) {
        this.firstname = customer.getFirstname();
        this.lastname = customer.getLastname();
        this.address = customer.getAddress();
        this.contact = customer.getContact();
    }

    public String getFirstname() {
        return firstname;
    }

    public Contact getContact() {
        return contact;
    }

    public String getLastname() {
        return lastname;
    }



    public Address getAddress() {
        return address;
    }

}
