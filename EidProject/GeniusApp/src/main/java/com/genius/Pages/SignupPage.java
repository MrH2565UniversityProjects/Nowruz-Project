package com.genius.Pages;

import com.AP.Cli.FormHandler;
import com.AP.Cli.InputHandler;
import com.AP.Cli.Menu;
import com.AP.Cli.OutputHandler;
import com.AP.Pages.Page;
import com.AP.Router;
import com.genius.Entities.Identity.Account;
import com.genius.Entities.Identity.ArtistProfile;
import com.genius.UnitOfWork;

import java.util.Scanner;

public class SignupPage extends Page {
    UnitOfWork unitOfWork;
    public SignupPage(UnitOfWork unitOfWork) {
        this.unitOfWork = unitOfWork;
    }
    @Override
    public void Initialize() {
        setName("SignUp Page");
    }
    @Override
    public boolean ShouldSaveInHistory() {
        return false;
    }
    @Override
    protected void ShowContent(Object[] params) {
        Account account = new Account();
        FormHandler.collectData(account);
        String password = InputHandler.getInput("Enter password:");
        String confirmPassword = InputHandler.getInput("Enter confirm password:");
        if(!password.equals(confirmPassword)){
            OutputHandler.PrintError("Password and confirm must be equal");
        }
        Menu menu = new Menu();
        menu.addOption("User",options -> {
            account.addRole("User");
            account.setIsVerified(true);
        });
        menu.addOption("Artist",options -> {
            account.addRole("Artist");
            ArtistProfile artistProfile = new ArtistProfile(InputHandler.getInput("Enter Bio"));
            account.setArtistProfile(artistProfile);
        });
        menu.navigateMenu("Select your Role");
        unitOfWork.getAccountManager().Register(account,password);
        Router.getInstance().navigate("Home");
    }
}
