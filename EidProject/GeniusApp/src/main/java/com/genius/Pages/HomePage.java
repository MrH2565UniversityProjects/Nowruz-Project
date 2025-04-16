package com.genius.Pages;

import java.util.Scanner;

import com.AP.Cli.Menu;
import com.AP.Pages.Page;
import com.AP.Router;
import com.AP.Session;

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


            if(Session.getInstance().isLoggedIn()){
                mainMenu.addOption("Artist",options -> {
                    Router.getInstance().navigate("Artist");
                });
                mainMenu.addOption("Albums",options -> {
                    Router.getInstance().navigate("Albums");
                });
                mainMenu.addOption("Songs",options -> {
                    Router.getInstance().navigate("Songs");
                });
                mainMenu.addOption("Logout",options -> {
                    Session.getInstance().logout();
                    Router.getInstance().navigate();
                });
            }else{
                mainMenu.addOption("Login",options -> {
                    Router.getInstance().navigate("Login");
                });
                mainMenu.addOption("SignUp",options -> {
                    Router.getInstance().navigate("Signup");
                });
            }
        mainMenu.navigateMenu(super.getName());
    }
}
