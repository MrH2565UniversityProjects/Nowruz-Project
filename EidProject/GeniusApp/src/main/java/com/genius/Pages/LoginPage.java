package com.genius.Pages;

import com.AP.Cli.FormHandler;
import com.AP.Cli.InputHandler;
import com.AP.Cli.Menu;
import com.AP.Cli.OutputHandler;
import com.AP.Identity.AccountBase;
import com.AP.Pages.Page;
import com.AP.Router;
import com.AP.Session;
import com.genius.Entities.Identity.Account;
import com.genius.UnitOfWork;

import java.util.Objects;
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
        var loginResult = unitOfWork.getAccountManager().Login(username,password);
        if(loginResult.isSuccess()) {
            AccountBase account = unitOfWork.getAccountManager().GetAccountByUsername(username);
            System.out.println(account.getPasswordHash());
            Session.getInstance().login(account);
            if(account.getRoles().size() > 1){
                Menu SelectRole = new Menu();
                for (int i = 0;i< account.getRoles().size() ;i++){
                    var role = account.getRoles().get(i);
                    int index = i;
                    SelectRole.addOption(role, option -> {
                        Session.getInstance().setCurrentAccountRole(index);
                    });
                }
                SelectRole.navigateMenu("Select The Role you want Login with");

            }else if(account.getRoles().size() == 1){
                Session.getInstance().setCurrentAccountRole(0);
            }
            if(Objects.equals(Session.getInstance().getCurrentAccountRole(), "Admin")){
                Router.getInstance().navigate("Admin/Dashboard");
            }else if(Objects.equals(Session.getInstance().getCurrentAccountRole(), "User")){
                Router.getInstance().navigate("Home");
            }
            else if(Objects.equals(Session.getInstance().getCurrentAccountRole(), "Artist")){
                Router.getInstance().navigate("Artist/Dashboard");
            }
        }else{
            OutputHandler.PrintError(loginResult.getMessage());
            Router.getInstance().navigate("Home");
        }

    }
}
