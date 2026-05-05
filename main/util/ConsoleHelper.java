package main.util;

import static main.util.Color.*;

public class ConsoleHelper {
    public void printMenu() {
        System.out.println("\n" + BLUE + "╔══════════════════════════════════════╗" + RESET);
        System.out.println(BLUE + "║" + CYAN + "   RESTAURANT RESERVATION SYSTEM      " + BLUE + "║" + RESET);
        System.out.println(BLUE + "╠══════════════════════════════════════╣" + RESET);
        // System.out.println(BLUE + "║" + RESET);
        System.out.println(
                BLUE + "║  " + GREEN + "1." + WHITE + " Add Reservation                  " + BLUE + "║" + RESET);
        System.out.println(
                BLUE + "║  " + GREEN + "2." + WHITE + " Cancel Reservation               " + BLUE + "║" + RESET);
        System.out.println(
                BLUE + "║  " + GREEN + "3." + WHITE + " View Reservations                " + BLUE + "║" + RESET);
        System.out.println(
                BLUE + "║  " + GREEN + "4." + WHITE + " View Waiting List                " + BLUE + "║" + RESET);
        System.out.println(
                BLUE + "║  " + GREEN + "5." + WHITE + " Show Available Tables            " + BLUE + "║" + RESET);
        System.out.println(
                BLUE + "║  " + RED + "6." + WHITE + " Exit                             " + BLUE + "║" + RESET);
        // System.out.println(BLUE + "║" + RESET);
        System.out.println(BLUE + "╚══════════════════════════════════════╝" + RESET);
        System.out.print("\n" + YELLOW + "Enter your choice: " + RESET);
    }

    public void printConfirmation(String message) {
        System.out.println(GREEN + "✓ " + message + RESET);
    }

    public void printError(String message) {
        System.out.println(RED + "✗ " + message + RESET);
    }

    public void printInfo(String message) {
        System.out.println(CYAN + "ℹ " + message + RESET);
    }

    public void printHeader(String title) {
        String line = "════════════════════════════════════════";
        int lineLength = line.length();
        int titleLength = title.length();
        int totalPadding = lineLength - titleLength;
        int leftPadding = totalPadding / 2;
        int rightPadding = totalPadding - leftPadding;

        System.out.println("\n" + BLUE + line + RESET);
        System.out.println(BLUE + " ".repeat(leftPadding) + CYAN + title + BLUE + " ".repeat(rightPadding) + RESET);
        System.out.println(BLUE + line + RESET);
    }

    public void printChoicePrompt() {
        System.out.print(YELLOW + "Enter your choice: " + RESET);
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
