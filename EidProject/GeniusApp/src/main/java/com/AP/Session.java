package com.AP;

import com.AP.Identity.AccountBase;

public class Session<TAccount extends AccountBase> {
    private static Session<?> instance;
    public static Session<?> getInstance(){
        if(instance == null)
            instance = new Session<>();
        return instance;
    }
    private TAccount currentAccount;
    public void login(TAccount Account) {
        currentAccount = Account;
    }

    public void logout() {
        currentAccount = null;
    }

    public boolean isLoggedIn() {
        return currentAccount != null;
    }

    public TAccount getCurrentAccount() {
        return currentAccount;
    }
}
