package com.genius;

import com.AP.Application;
import com.AP.Router;
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
        Router.getInstance().addRoute("Albums",new  com.genius.Pages.Music.Albums.IndexPage(unitOfWork));
        Router.getInstance().addRoute("Albums/Upsert",new com.genius.Pages.Music.Albums.UpsertPage(unitOfWork));
        Router.getInstance().addRoute("Albums/Delete",new com.genius.Pages.Music.Albums.DeletePage(unitOfWork));

        Router.getInstance().addRoute("Songs",new  com.genius.Pages.Music.Songs.IndexPage(unitOfWork));
        Router.getInstance().addRoute("Songs/Upsert",new com.genius.Pages.Music.Songs.UpsertPage(unitOfWork));
        Router.getInstance().addRoute("Songs/Delete",new com.genius.Pages.Music.Songs.DeletePage(unitOfWork));

        Router.getInstance().addRoute("Login",new LoginPage(unitOfWork));
        Router.getInstance().addRoute("Signup",new SignupPage(unitOfWork));
    }
    public static void main(String[] args) {
        Application app = Application.Create();
        Configure(app);
        app.Run();
    }




}
