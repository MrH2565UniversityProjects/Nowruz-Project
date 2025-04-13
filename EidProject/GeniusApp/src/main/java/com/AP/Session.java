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

    public AccountBase getCurrentAccount() {
        return currentAccount;
    }
}
