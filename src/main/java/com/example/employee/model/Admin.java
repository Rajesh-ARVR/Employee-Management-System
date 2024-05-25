package com.example.employee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin {
    
    @Id
    private String username;
    private String password;

    // Constructor with parameters
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Default constructor
    public Admin() {}

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Override toString method for debugging
    @Override
    public String toString() {
        return "Admin [username=" + username + ", password=" + password + "]";
    }
}
