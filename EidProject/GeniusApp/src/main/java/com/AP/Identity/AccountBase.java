package com.AP.Identity;

import com.AP.EntityBase;

import java.util.ArrayList;
import java.util.List;

public abstract class AccountBase extends EntityBase {
    private String username;
    private String passwordHash;
    private final List<String> Roles = new ArrayList<>();
    public AccountBase(){

    }
    // Constructor
    public AccountBase(String username, String passwordHash) {
        super();
        this.username = username;
        this.passwordHash = passwordHash;
    }
    public void addRole(String role){
        Roles.add(role);
    }
    public boolean hasRole(String role){
        return Roles.contains(role);
    }
    public List<String> getRoles(){
        return Roles;
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
