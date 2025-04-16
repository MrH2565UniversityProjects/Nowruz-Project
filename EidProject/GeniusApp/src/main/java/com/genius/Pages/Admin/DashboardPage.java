package com.genius.Pages.Admin;

import com.AP.Cli.Menu;
import com.AP.Pages.Page;
import com.AP.Router;
import com.AP.Session;

public class DashboardPage extends Page {
    public DashboardPage() {
    }
    @Override
    public void Initialize() {
        setName("Dashboard");
    }

    @Override
    protected void ShowContent(Object[] param) {
            Menu mainMenu = new Menu();
            if(Session.getInstance().isLoggedIn()){
                mainMenu.addOption("Albums",options -> {
                    Router.getInstance().navigate("Albums");
                });
                mainMenu.addOption("Songs",options -> {
                    Router.getInstance().navigate("Songs");
                });
            }
            else{
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
