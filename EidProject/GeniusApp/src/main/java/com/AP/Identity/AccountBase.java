package com.AP.Identity;

import com.AP.Annotations.UserInput;
import com.AP.EntityBase;

import java.util.ArrayList;
import java.util.List;

public abstract class AccountBase extends EntityBase {
    @UserInput(label = "Enter your Username",required = true)
    private String username;
    private String passwordHash;
    private final List<String> Roles = new ArrayList<>();
    private boolean isVerified = false;
    public AccountBase(String id){
        super(id);
    }
    public AccountBase(){

    }
    // Constructor
    public AccountBase(String id,String username, String passwordHash) {
        super(id);
        this.username = username;
        this.passwordHash = passwordHash;
    }
    public AccountBase(String username, String passwordHash) {
        super();
        this.username = username;
        this.passwordHash = passwordHash;
    }
    public boolean getIsVerified() {
        return isVerified;
    }
    public void setIsVerified(boolean value){
        isVerified = value;
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
