package com.genius.Pages;

import com.AP.Pages.Page;
import com.AP.Router;

import java.util.Scanner;

public class SignupPage extends Page {
    private Scanner scanner;
    public SignupPage(Scanner scanner) {
        this.scanner = scanner;
    }
    @Override
    public void Initialize() {
        setName("SignUpPage");
    }

    @Override
    protected void ShowContent(Object[] params) {

    }
}
