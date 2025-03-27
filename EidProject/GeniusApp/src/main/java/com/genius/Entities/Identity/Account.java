package com.genius.Entities.Identity;

import com.genius.Entities.BaseEntity;

public class Account extends BaseEntity {
    private String name;
    private int age;
    private String email;
    private String username;
    private String passwordHash;
    
    public Account(){

    }
    // Constructor
    public Account(String name, int age, String email, String username, String passwordHash) {
        super();
        this.name = name;
        this.age = age;
        this.email = email;
        this.username = username;
        this.passwordHash = passwordHash;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}