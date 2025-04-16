package com.genius.Pages.Artist;

import com.AP.Cli.Menu;
import com.AP.Pages.Page;

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
        mainMenu.navigateMenu(super.getName());
    }
}
