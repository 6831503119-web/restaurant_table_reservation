package main.util;

import java.util.Scanner;
import static main.util.Color.*;

public class Validation {

    private static ConsoleHelper helper = new ConsoleHelper();

    /**
     * Validates and returns a name from user input
     * Name must contain only letters and spaces, not empty
     */
    public static String validateName(Scanner sc) {
        while (true) {
            System.out.print(CYAN + "Enter name: " + RESET);
            String name = sc.nextLine();

            if (name.matches("^[a-zA-Z ]+$") && !name.trim().isEmpty()) {
                return name;
            } else {
                helper.printError("Invalid name! Use letters and spaces only.");
            }
        }
    }

    /**
     * Validates and returns the number of people from user input
     * Must be a positive integer greater than 0
     */
    public static int validatePeople(Scanner sc) {
        while (true) {
            System.out.print(CYAN + "Number of people: " + RESET);

            if (sc.hasNextInt()) {
                int people = sc.nextInt();
                sc.nextLine(); // clear buffer

                if (people > 0) {
                    return people;
                } else {
                    helper.printError("Number must be greater than 0!");
                }
            } else {
                helper.printError("Invalid number! Please enter a valid integer.");
                sc.next(); // remove invalid input
            }
        }
    }

    /**
     * Validates menu choice from user input
     * Must be an integer between 1 and maxChoice
     * Empty input (just Enter key) is also invalid
     */
    public static int validateChoice(Scanner sc, int maxChoice) {
        while (true) {
            String input = sc.nextLine().trim();
            
            // Check if input is empty
            if (input.isEmpty()) {
                helper.printError("Input cannot be empty! Please enter a choice.");
                helper.printChoicePrompt();
                continue;
            }
            
            // Check if input is a valid integer
            try {
                int choice = Integer.parseInt(input);
                
                if (choice >= 1 && choice <= maxChoice) {
                    return choice;
                } else {
                    helper.printError("Invalid choice! Please enter a number between 1 and " + maxChoice);
                    helper.printChoicePrompt();
                }
            } catch (NumberFormatException e) {
                helper.printError("Invalid input! Please enter a number.");
                helper.printChoicePrompt();
            }
        }
    }

    /**
     * Validates confirmation input (yes/no)
     * Returns true for yes, false for no
     */
    public static boolean validateConfirmation(Scanner sc, String message) {
        while (true) {
            System.out.print(CYAN + message + " (yes/no): " + RESET);
            String input = sc.nextLine().trim().toLowerCase();

            if (input.equals("yes") || input.equals("y")) {
                return true;
            } else if (input.equals("no") || input.equals("n")) {
                return false;
            } else {
                helper.printError("Invalid input! Please enter 'yes' or 'no'.");
            }
        }
    }

    /**
     * Validates email format
     */
    public static String validateEmail(Scanner sc) {
        while (true) {
            System.out.print(CYAN + "Enter email: " + RESET);
            String email = sc.nextLine();

            if (email.matches("^[A-Za-z0-9+_.-]+@(.+)$") && !email.trim().isEmpty()) {
                return email;
            } else {
                helper.printError("Invalid email format!");
            }
        }
    }

    /**
     * Validates phone number (digits only, 10 digits)
     */
    public static String validatePhoneNumber(Scanner sc) {
        while (true) {
            System.out.print(CYAN + "Enter phone number (10 digits): " + RESET);
            String phone = sc.nextLine();

            if (phone.matches("^[0-9]{10}$")) {
                return phone;
            } else {
                helper.printError("Invalid phone number! Please enter exactly 10 digits.");
            }
        }
    }
}
