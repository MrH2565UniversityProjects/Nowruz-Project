package com.genius.Services.Identity;

import com.genius.Entities.Identity.Account;
import com.genius.Enums.AccountRole;
import com.genius.IdentityResult;

public interface IAccountManager {
    public boolean CheckUsernameAvailability(String username);
    IdentityResult Register(Account account, String password);
    boolean Login(String username, String password);
    void EditAccount(Account account);
    void DeleteAccount(String accountId);
    IdentityResult ChangePassword(String accountId, String oldPassword, String newPassword);
    Account GetAccountById(String accountId);
    Account GetAccountByUsername(String username);
}
