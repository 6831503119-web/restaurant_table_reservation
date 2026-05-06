package main;

import java.util.Scanner;

import main.core.ReservationSystem;
import main.util.ConsoleHelper;
import main.util.Validation;
import main.exception.*;
import static main.util.Color.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ConsoleHelper consoleHelper = new ConsoleHelper();
        ReservationSystem system = new ReservationSystem();

        int choice;

        do {
            // Display menu
            consoleHelper.printMenu();

            // Use Validation class for menu choice
            choice = Validation.validateChoice(sc, 7);

            switch (choice) {
                case 1:
                    consoleHelper.printHeader("Add Reservation");

                    // Use Validation class for name and people
                    String name = Validation.validateName(sc);
                    int people = Validation.validatePeople(sc);

                    try {
                        system.addReservation(name, people);
                    } catch (InvalidNameException e) {
                        consoleHelper.printError(e.getMessage());
                    } catch (InvalidPeopleException e) {
                        consoleHelper.printError(e.getMessage());
                    } catch (NoTablesAvailableException e) {
                        consoleHelper.printError(e.getMessage());
                    }
                    break;

                case 2:
                    consoleHelper.printHeader("Cancel Reservation");
                    String cancelName = Validation.validateName(sc);

                    try {
                        system.cancelReservation(cancelName);
                    } catch (ReservationNotFoundException e) {
                        consoleHelper.printError(e.getMessage());
                    }
                    ConsoleHelper.continueOption(sc);
                    break;

                case 3:
                    consoleHelper.printHeader("CURRENT RESERVATIONS");
                    system.viewReservations();
                    ConsoleHelper.continueOption(sc);
                    break;

                case 4:
                    consoleHelper.printHeader("WAITING LIST");
                    system.viewWaitingList();
                    ConsoleHelper.continueOption(sc);
                    break;

                case 5:
                    consoleHelper.printHeader("AVAILABLE TABLES");
                    system.showAvailableTables();
                    ConsoleHelper.continueOption(sc);
                    break;

                case 6:
                    ConsoleHelper.showDeveloperInfo();
                    break;

                case 7:
                    consoleHelper.printInfo("Thank you for using Restaurant Reservation System!");
                    System.out.println(YELLOW + "Exiting..." + RESET);
                    break;

                default:
                    consoleHelper.printError("Invalid choice! Please try again.");
            }

        } while (choice != 7);

        sc.close();
    }
}
