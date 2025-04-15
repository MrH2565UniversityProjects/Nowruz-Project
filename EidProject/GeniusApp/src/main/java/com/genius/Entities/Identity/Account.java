package com.genius.Entities.Identity;

import com.AP.Annotations.UserInput;
import com.AP.Identity.AccountBase;

import java.util.ArrayList;
import java.util.List;

public class Account extends AccountBase {
    @UserInput(label = "Enter your name",required = true)
    private String name;
    @UserInput(label = "Enter your age",required = false)
    private int age;
    @UserInput(label = "Enter your email",required = true)
    private String email;
    public Account(){

    }
    // Constructor
    public Account(String id,String name, int age, String email, String username, String passwordHash) {
        super(id);
        this.name = name;
        this.age = age;
        this.email = email;
        setUsername(username);
        setPasswordHash(passwordHash);
    }
    public Account(String name, int age, String email, String username, String passwordHash) {
        super();
        this.name = name;
        this.age = age;
        this.email = email;
        setUsername(username);
        setPasswordHash(passwordHash);
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

}