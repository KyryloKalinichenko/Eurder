package com.example.eurder.domain.customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class Contact {
    private String email;

    private String phoneNumber;

    public Contact(String email, String phoneNumber) {
        if (email == null || phoneNumber == null){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "The contact information should be filled.");
        }
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
