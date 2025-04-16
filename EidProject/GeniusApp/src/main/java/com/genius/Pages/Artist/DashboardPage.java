package com.genius.Pages.Artist;

import com.AP.Cli.Menu;
import com.AP.Pages.Page;
import com.AP.Router;

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
        mainMenu.addOption("Suggested Edit Lyrics" , options -> {
            Router.getInstance().navigate("Artist/Songs/SuggestEdit");
        });
        mainMenu.navigateMenu(super.getName());
    }
}
