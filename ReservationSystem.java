import java.util.*;

class ReservationSystem {

    LinkedList<Reservation> reservations = new LinkedList<>();
    Queue<Reservation> waitingQueue = new LinkedList<>();
    Stack<Integer> availableTables = new Stack<>();

    int totalTables = 3;

    // Constructor to initialize tables
    ReservationSystem() {
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
    void addReservation(String name, int people) {
        if (isTableAvailable()) {
            int table = assignTable();
            Reservation r = new Reservation(name, people, table);
            reservations.add(r);
            System.out.println("Reservation confirmed! Table " + table + " assigned.");
        } else {
            Reservation r = new Reservation(name, people, -1);
            waitingQueue.add(r);
            System.out.println("No table available. Added to waiting list.");
        }
    }

    // Cancel Reservation
    void cancelReservation(String name) {
        Reservation r = findReservation(name, 0);

        if (r == null) {
            System.out.println("Reservation not found.");
            return;
        }

        reservations.remove(r);

        // Return table back to stack
        availableTables.push(r.getTableNumber());

        System.out.println("Reservation cancelled. Table " + r.getTableNumber() + " is now free.");

        // Move from waiting queue if available
        if (!waitingQueue.isEmpty()) {
            Reservation next = waitingQueue.poll();
            int table = assignTable();
            next.setTableNumber(table);
            reservations.add(next);

            System.out.println("Moved from waiting list:");
            next.display();
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
    void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations.");
            return;
        }

        System.out.println("\n--- Reservations ---");
        displayRecursive(0);
    }

    // Recursive Traversal
    void displayRecursive(int index) {
        if (index >= reservations.size()) return;

        reservations.get(index).display();
        displayRecursive(index + 1);
    }

    // View Waiting List
    void viewWaitingList() {
        if (waitingQueue.isEmpty()) {
            System.out.println("Waiting list is empty.");
            return;
        }

        System.out.println("\n--- Waiting List ---");
        for (Reservation r : waitingQueue) {
            System.out.println("Name: " + r.getName() +
                    " | People: " + r.getPeople());
        }
    }

    // Show available tables
    void showAvailableTables() {
        System.out.println("Available Tables (Stack): " + availableTables);
    }
}