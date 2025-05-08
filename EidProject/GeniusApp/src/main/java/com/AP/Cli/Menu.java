package com.AP.Cli;

import com.AP.Router;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final List<String> menuOptions = new ArrayList<>();
    private final List<Consumer<String>> actions = new ArrayList<>();
    private boolean hasBack = true;
    public void SetHasBack(boolean value){
        hasBack = value;
    }
    public void displayMenu(String title) {
        System.out.println("==== " + title + " ====");
        for (int i = 0; i < menuOptions.size(); i++) {
            System.out.println((i + 1) + ". " + menuOptions.get(i));
        }
        System.out.print("Select an option by number " + (hasBack ? "(0 for back) " : "")+":");
    }

    public void addOption(String optionName, Consumer<String> action) {
        menuOptions.add(optionName);
        actions.add(action);
    }
    public void navigateMenu(String title) {
        navigateMenu(title,false);
    }

    public void navigateMenu(String title,boolean hasCallback) {
        boolean repeat = true;
        while (repeat) {
            displayMenu(title);
            String input = scanner.nextLine();
            if (isValidOption(input)) {
                int selectedIndex = Integer.parseInt(input) - 1;
                if(selectedIndex == -1 && hasBack) {
                    Router.getInstance().goBack();
                    break;
                }
                Consumer<String> action = actions.get(selectedIndex);
                action.accept(menuOptions.get(selectedIndex));
                repeat = hasCallback;
            } else {
                System.out.println("Invalid option, please try again.");
            }
        }
    }

    private boolean isValidOption(String input) {
        try {
            int optionNumber = Integer.parseInt(input);
            return (optionNumber > 0 && optionNumber <= menuOptions.size()) || (hasBack && optionNumber == 0);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void exitMenu() {
        System.out.println("Exiting menu...");
        System.exit(0);
    }
}
