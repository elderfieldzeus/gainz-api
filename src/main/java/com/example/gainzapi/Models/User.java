package com.example.gainzapi.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;

    protected User() {}

    public User(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return String.format("[%d]-%s", id, username);
    }

    public Long getId() {return id;}
    public String getUsername() {return username;}
}
