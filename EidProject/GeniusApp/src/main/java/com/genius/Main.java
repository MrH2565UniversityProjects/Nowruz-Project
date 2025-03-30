package com.genius;

import com.AP.Application;
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
        AddRoutes(app);
    }
    private static void AddRoutes(Application app){
        app.getRouter().addRoute("Home",new HomePage(app.getRouter(),scanner));
        app.getRouter().addRoute("Login",new LoginPage(app.getRouter(),scanner));
        app.getRouter().addRoute("Signup",new SignupPage(app.getRouter(),scanner));
    }
    public static void main(String[] args) {
        Application app = Application.Create();
        Configure(app);
        app.Run();
    }




}
