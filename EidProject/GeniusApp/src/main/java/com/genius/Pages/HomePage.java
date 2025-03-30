package com.genius.Pages;

import java.util.Scanner;
import com.AP.Pages.Page;
import com.AP.Router;

public class HomePage extends Page {
    private Scanner scanner;
    private Router router;
    public HomePage(Router router,Scanner scanner) {
        this.router = router;
        this.scanner = scanner;
    }
    @Override
    public void Initialize() {
        setName("HomePage");
    }

    @Override
    protected void ShowContent() {
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. SignUp");
            System.out.print("Select an option or enter route: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    router.navigate("Login");
                    return;
                case "2":
                    router.navigate("Signup");
                    return;
                default:
                    router.navigate(input);
            }
        }
    }
}
