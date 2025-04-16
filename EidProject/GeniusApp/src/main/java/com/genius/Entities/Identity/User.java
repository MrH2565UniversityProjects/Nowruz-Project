
package com.genius.Entities.Identity;

public class User extends Account {

    public User() {

    }

    public User(String name, int age, String email, String username, String password) {
        super(name, age, email, username, password);
    }
}