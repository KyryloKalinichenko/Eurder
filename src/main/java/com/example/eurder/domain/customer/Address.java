package com.example.eurder.domain.customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class Address {
    private String country;
    private String city;
    private String postCode;
    private int homeNumber;

    public Address(String country, String city, String postCode, int homeNumber) {

        if (country == null || city == null || postCode == null){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Address should be filled.");
        }
        this.country = country;
        this.city = city;
        this.postCode = postCode;
        this.homeNumber = homeNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getPostCode() {
        return postCode;
    }

    public int getHomeNumber() {
        return homeNumber;
    }
}
