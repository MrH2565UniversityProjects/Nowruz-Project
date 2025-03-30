package com.genius.Pages;

import com.AP.Pages.Page;
import com.AP.Router;

import java.util.Scanner;

public class LoginPage extends Page {
    private Scanner scanner;
    private Router router;
    public LoginPage(Router router,Scanner scanner) {
        this.router = router;
        this.scanner = scanner;
    }
    @Override
    public void Initialize() {
        setName("Login Page");
    }

    @Override
    protected void ShowContent() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (authenticate(username, password)) {
            System.out.println("Login successful!");
            router.navigate();
        } else {
            System.out.println("Invalid credentials. Please try again.");
            ShowContent();
        }
    }

    private boolean authenticate(String username, String password) {
        return "admin".equals(username) && "admin".equals(password);
    }
}
