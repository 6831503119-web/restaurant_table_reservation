package main.core;

import java.util.*;
import main.util.ConsoleHelper;
import main.exception.*;
import static main.util.Color.*;

public class ReservationSystem {

    LinkedList<Reservation> reservations = new LinkedList<>();
    Queue<Reservation> waitingQueue = new LinkedList<>();
    Stack<Integer> availableTables = new Stack<>();
    ConsoleHelper helper = new ConsoleHelper();

    int totalTables = 3;

    // Constructor to initialize tables
    public ReservationSystem() {
        for (int i = totalTables; i >= 1; i--) {
            availableTables.push(i);
        }
    }

    // Check table availability
    boolean isTableAvailable() {
        return !availableTables.isEmpty();
    }

    // Assign table using Stack
    int assignTable() {
        return availableTables.pop();
    }

    // Add Reservation
    public void addReservation(String name, int people)
            throws InvalidNameException, InvalidPeopleException, NoTablesAvailableException {
        // Validate name
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidNameException("Name cannot be empty.");
        }

        // Validate people count
        if (people <= 0) {
            throw new InvalidPeopleException(people);
        }

        if (isTableAvailable()) {
            int table = assignTable();
            Reservation r = new Reservation(name, people, table);
            reservations.add(r);
            helper.printConfirmation("Reservation for " + name + " confirmed! Table " + table + " assigned.");
        } else {
            Reservation r = new Reservation(name, people, -1);
            waitingQueue.add(r);
            helper.printInfo("No table available. " + name + " added to waiting list.");
        }
    }

    // Cancel Reservation
    public void cancelReservation(String name) throws ReservationNotFoundException {
        if (name == null || name.trim().isEmpty()) {
            throw new ReservationNotFoundException("Name cannot be empty.");
        }

        Reservation r = findReservation(name, 0);

        if (r == null) {
            throw new ReservationNotFoundException(name);
        }

        reservations.remove(r);

        // Return table back to stack
        availableTables.push(r.getTableNumber());

        helper.printConfirmation(
                "Reservation for " + name + " cancelled. Table " + r.getTableNumber() + " is now free.");

        // Move from waiting queue if available
        if (!waitingQueue.isEmpty()) {
            Reservation next = waitingQueue.poll();
            int table = assignTable();
            next.setTableNumber(table);
            reservations.add(next);

            helper.printConfirmation("Moved from waiting list: " + next.getName() + " assigned to Table " + table);
        }
    }

    // Recursive Search
    Reservation findReservation(String name, int index) {
        if (index >= reservations.size())
            return null;

        if (reservations.get(index).getName().equalsIgnoreCase(name)) {
            return reservations.get(index);
        }

        return findReservation(name, index + 1);
    }

    // View Reservations (Recursive)
    public void viewReservations() {
        if (reservations.isEmpty()) {
            helper.printInfo("No reservations at the moment.");
            return;
        }

        System.out.println(GREEN + "\n┌──────────────────────────────────────┐" + RESET);
        System.out.println(GREEN + "│        CURRENT RESERVATIONS          │" + RESET);
        System.out.println(GREEN + "└──────────────────────────────────────┘" + RESET);
        displayRecursive(0);
    }

    // Recursive Traversal
    void displayRecursive(int index) {
        if (index >= reservations.size())
            return;

        reservations.get(index).display();
        displayRecursive(index + 1);
    }

    // View Waiting List
    public void viewWaitingList() {
        if (waitingQueue.isEmpty()) {
            helper.printInfo("Waiting list is empty.");
            return;
        }

        System.out.println(YELLOW + "\n┌──────────────────────────────────────┐" + RESET);
        System.out.println(YELLOW + "│          WAITING LIST                │" + RESET);
        System.out.println(YELLOW + "└──────────────────────────────────────┘" + RESET);
        for (Reservation r : waitingQueue) {
            System.out.println(
                    YELLOW + "  • " + WHITE + r.getName() + YELLOW + " (" + r.getPeople() + " people)" + RESET);
        }
    }

    // Show available tables
    public void showAvailableTables() {
        if (availableTables.isEmpty()) {
            helper.printError("No tables available.");
            return;
        }
        System.out.println(GREEN + "Available Tables: " + availableTables + RESET);
    }
}