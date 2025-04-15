package com.genius.Services.Identity;

import com.genius.Data.DataStorage;
import com.genius.Entities.Identity.Account;
import com.genius.Entities.Identity.Admin;
import com.genius.Enums.AccountRole;
import com.genius.IdentityResult;
import com.genius.Services.*;
import com.genius.Utils.*;
import java.util.List;
import java.util.function.Predicate;

public class AccountManager implements IAccountManager {
    private final DataStorage dataStorage;
    public AccountManager(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    @Override
    public boolean CheckUsernameAvailability(String username) {
        boolean isUsernameTaken = dataStorage.Accounts.stream()
                .anyMatch(existingAccount -> existingAccount.getUsername().equals(username));
        return !isUsernameTaken;
    }

    @Override
    public IdentityResult Register(Account account, String password) {
        if(!CheckUsernameAvailability(account.getUsername())){
            return IdentityResult.CreateFailedResult("Username is Already");
        }
        String hashedPassword = HashUtil.hashPassword(password, account.getId());
        account.setPasswordHash(hashedPassword);
        dataStorage.Accounts.add(account);
        return IdentityResult.CreateSuccessResult("Account successfully registered!");
    }

    @Override
    public IdentityResult Login(String username, String password) {
        Account account = GetAccountByUsername(username);
        if (account == null) {
            //return IdentityResult.CreateFailedResult("Username or password is incorrect");
            return IdentityResult.CreateFailedResult("Username is incorrect");
        }
        String hashedPassword = HashUtil.hashPassword(password, account.getId());
        if(!account.getIsVerified()){
            return IdentityResult.CreateFailedResult("Your account is not verified");
        }
        if(account.getPasswordHash().equals(hashedPassword)){
            return IdentityResult.CreateSuccessResult();
        }else{
            return IdentityResult.CreateFailedResult("Password is incorrect");
            //return IdentityResult.CreateFailedResult("Username or password is incorrect");
        }
    }

    @Override
    public void EditAccount(Account model) {
        for (int i = 0; i < dataStorage.Accounts.size(); i++) {
            if (dataStorage.Accounts.get(i).getId().equals(model.getId())) {
                dataStorage.Accounts.set(i, model);
                return;
            }
        }
    }

    @Override
    public void DeleteAccount(String accountId) {
        dataStorage.Accounts.removeIf(account -> account.getId().equals(accountId));
    }


    @Override
    public IdentityResult ChangePassword(String accountId, String oldPassword, String newPassword) {
        Account account = GetAccountById(accountId);
        if (account == null) {
            return IdentityResult.CreateFailedResult("Account not found.");
        }
        String hashedOldPassword = HashUtil.hashPassword(oldPassword, account.getId());
        if (!account.getPasswordHash().equals(hashedOldPassword)) {
            return IdentityResult.CreateFailedResult("Old password is incorrect.");
        }
        String hashedNewPassword = HashUtil.hashPassword(newPassword, account.getId());
        account.setPasswordHash(hashedNewPassword);
        return IdentityResult.CreateSuccessResult("Password successfully changed.");
    }

    @Override
    public Account GetAccountById(String accountId) {
        return dataStorage.Accounts.stream()
                .filter(account -> account.getId().equals(accountId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Account GetAccountByUsername(String username) {
        return dataStorage.Accounts.stream()
                .filter(account -> account.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
}
