package com.example.eurder.domain.user;

public class User {

    private int id;
    private String firstname;
    private String lastname;
    private static int counter;

    public User(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        id = counter++;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
