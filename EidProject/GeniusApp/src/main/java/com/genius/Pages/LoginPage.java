package com.genius.Pages;

import com.AP.Cli.FormHandler;
import com.AP.Cli.InputHandler;
import com.AP.Cli.OutputHandler;
import com.AP.Identity.AccountBase;
import com.AP.Pages.Page;
import com.AP.Router;
import com.AP.Session;
import com.genius.Entities.Identity.Account;
import com.genius.UnitOfWork;

import java.util.Scanner;

public class LoginPage extends Page {
    UnitOfWork unitOfWork;
    public LoginPage(UnitOfWork unitOfWork) {
        this.unitOfWork = unitOfWork;
    }
    @Override
    public void Initialize() {
        setName("Login Page");
    }

    @Override
    protected void ShowContent(Object[] params) {
        String username = InputHandler.getInput("Enter Username");
        String password = InputHandler.getInput("Enter Password");
        if(unitOfWork.getAccountManager().Login(username,password)) {
            AccountBase account = unitOfWork.getAccountManager().GetAccountByUsername(username);
            Session.getInstance().login(account);
        };
        Router.getInstance().navigate("Home");
    }

}
