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
        Router.getInstance().addRoute("Login",new LoginPage(scanner));
        Router.getInstance().addRoute("Signup",new SignupPage(scanner));
    }
    public static void main(String[] args) {
        Application app = Application.Create();
        Configure(app);
        app.Run();
    }




}
