package com.AP.Cli;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final List<String> menuOptions = new ArrayList<>();
    private final List<Consumer<String>> actions = new ArrayList<>();

    public void displayMenu(String title) {
        System.out.println("==== " + title + " ====");
        for (int i = 0; i < menuOptions.size(); i++) {
            System.out.println((i + 1) + ". " + menuOptions.get(i));
        }
        System.out.print("Select an option by number: ");
    }

    public void addOption(String optionName, Consumer<String> action) {
        menuOptions.add(optionName);
        actions.add(action);
    }

    public void navigateMenu(String title) {
        while (true) {
            displayMenu(title);

            String input = scanner.nextLine();
            if (isValidOption(input)) {
                int selectedIndex = Integer.parseInt(input) - 1;
                Consumer<String> action = actions.get(selectedIndex);
                action.accept(menuOptions.get(selectedIndex));
            } else {
                System.out.println("Invalid option, please try again.");
            }
        }
    }

    private boolean isValidOption(String input) {
        try {
            int optionNumber = Integer.parseInt(input);
            return optionNumber > 0 && optionNumber <= menuOptions.size();
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void exitMenu() {
        System.out.println("Exiting menu...");
        System.exit(0);
    }
}
