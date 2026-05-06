package main.util;

import static main.util.Color.*;

import java.util.Scanner;

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
                BLUE + "║  " + GREEN + "6." + WHITE + " Developer Info                   " + BLUE + "║" + RESET);
        System.out.println(
                BLUE + "║  " + RED + "7." + WHITE + " Exit                             " + BLUE + "║" + RESET);
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
        System.out.println(YELLOW + "ℹ " + message + RESET);
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

    public static void showDeveloperInfo() {

        // Top Border
        System.out.println(CYAN + "===========================================================" + RESET);

        // Title
        System.out.println(
                CYAN + "|          Restaurant Table Reservation System            |" + RESET);

        System.out.println(CYAN + "===========================================================" + RESET);

        // Group Info
        System.out.println(YELLOW + "| Group Name  : Anubis                                    |" + RESET);
        System.out.println(YELLOW + "| University  : Mae Fah Luang University                  |" + RESET);
        System.out.println(YELLOW + "| School      : Applied Digital Technology                |" + RESET);
        System.out.println(YELLOW + "| Major       : Software Engineering                      |" + RESET);

        // Description
        System.out.println(GREEN + "| Description : First Year (Java(DSA) Group Project)      |" + RESET);

        // Members Header
        System.out.println(CYAN + "===========================================================" + RESET);
        System.out.println(WHITE + "| Members:                                                |" + RESET);

        // Members List
        System.out.println(WHITE + "| 6831503002 - Mr. Aung Kyaw Min Htet                     |" + RESET);
        System.out.println(WHITE + "| 6831503011 - Mr. Kyaw Zin Htike                         |" + RESET);
        System.out.println(WHITE + "| 6831503022 - Mr. Kaung Sett Paing                       |" + RESET);
        System.out.println(WHITE + "| 6831503119 - Mr. Bhone Pyae Ko                          |" + RESET);

        // Footer
        System.out.println(CYAN + "===========================================================" + RESET);
        System.out.println(YELLOW + "| Created Date : 05.05.2026                               |" + RESET);
        System.out.println(YELLOW + "| Version      : 1.0.0.0                                  |" + RESET);

        // Bottom Border
        System.out.println(CYAN + "===========================================================" + RESET);
        
        continueOption(new Scanner(System.in));
    }

    public static void continueOption(Scanner sc) {

        System.out.print("\nPress only ");

        System.out.print(GREEN + "\"Enter\"" + RESET);

        System.out.print(" to ");

        System.out.println(YELLOW + "continue..." + RESET);

        sc.nextLine(); // wait for Enter
    }

}
