package com.AP;

import com.AP.Identity.AccountBase;

public class Session {
    private static Session instance;
    public static Session getInstance(){
        if(instance == null)
            instance = new Session();
        return instance;
    }
    private AccountBase currentAccount;
    public void login(AccountBase Account) {
        currentAccount = Account;
    }

    public void logout() {
        currentAccount = null;
    }

    public boolean isLoggedIn() {
        return currentAccount != null;
    }
    private String CurrentAccountRole;
    public String getCurrentAccountRole(){
        return CurrentAccountRole;
    }
    public void setCurrentAccountRole(int index){
        CurrentAccountRole = currentAccount.getRoles().get(index);
    }
    public AccountBase getCurrentAccount() {
        return currentAccount;
    }
}
