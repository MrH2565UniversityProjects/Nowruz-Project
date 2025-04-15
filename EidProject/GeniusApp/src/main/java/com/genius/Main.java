package com.genius;

import com.AP.Application;
import com.AP.Router;
import com.genius.Pages.Artist.Albums.DeletePage;
import com.genius.Pages.Artist.Albums.IndexPage;
import com.genius.Pages.Artist.Albums.UpsertPage;
import com.genius.Pages.HomePage;
import com.genius.Pages.LoginPage;


import com.genius.Pages.SignupPage;

import java.util.Scanner;

public class Main {
    static Scanner scanner;
    static UnitOfWork unitOfWork;

    public static void Configure(Application app){
        scanner = new Scanner(System.in);
        unitOfWork = new UnitOfWork();
        AddRoutes();
    }
    private static void AddRoutes(){
        Router.getInstance().addRoute("Home",new HomePage());
        Router.getInstance().addRoute("Artist/Albums",new IndexPage(unitOfWork));
        Router.getInstance().addRoute("Artist/Albums/Upsert",new UpsertPage(unitOfWork));
        Router.getInstance().addRoute("Artist/Albums/Delete",new DeletePage(unitOfWork));

        Router.getInstance().addRoute("Artist/Songs",new com.genius.Pages.Artist.Songs.IndexPage(unitOfWork));
        Router.getInstance().addRoute("Artist/Songs/Upsert",new com.genius.Pages.Artist.Songs.UpsertPage(unitOfWork));
        Router.getInstance().addRoute("Artist/Songs/Delete",new com.genius.Pages.Artist.Songs.DeletePage(unitOfWork));

        Router.getInstance().addRoute("Admin/Dashboard",new  com.genius.Pages.Admin.DashboardPage());
        Router.getInstance().addRoute("Login",new LoginPage(unitOfWork));
        Router.getInstance().addRoute("Signup",new SignupPage(unitOfWork));
    }
    public static void main(String[] args) {
        Application app = Application.Create();
        Configure(app);
        app.Run();
    }




}
