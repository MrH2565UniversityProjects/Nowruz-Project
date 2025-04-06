package com.genius.Pages;

import java.util.Scanner;

import com.AP.Cli.Menu;
import com.AP.Pages.Page;
import com.AP.Router;

public class HomePage extends Page {
    public HomePage() {
    }
    @Override
    public void Initialize() {
        setName("HomePage");
    }

    @Override
    protected void ShowContent(Object[] param) {
            Menu mainMenu = new Menu();
            mainMenu.addOption("Login",options -> {
                Router.getInstance().navigate("Login");
            });
            mainMenu.addOption("SignUp",options -> {
                Router.getInstance().navigate("SignUp");
            });
        mainMenu.navigateMenu(super.getName());
    }
}
