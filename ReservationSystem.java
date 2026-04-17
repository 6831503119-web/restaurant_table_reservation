import java.util.*;

class ReservationSystem {

    LinkedList<Reservation> reservations = new LinkedList<>();
    Queue<Reservation> waitingQueue = new LinkedList<>();

    int totalTables = 3;

    // Check table availability
    boolean isTableAvailable() {
        return reservations.size() < totalTables;
    }

    // Assign table number
    int assignTable() {
        return reservations.size() + 1;
    }

    // Add Reservation
    void addReservation(String name, int people) {
        if (isTableAvailable()) {
            int table = assignTable();
            Reservation r = new Reservation(name, people, table);
            reservations.add(r);
            System.out.println("Reservation confirmed!");
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
        System.out.println("Reservation cancelled.");

        // Move from queue if available
        if (!waitingQueue.isEmpty()) {
            Reservation next = waitingQueue.poll();
            next.setTableNumber(assignTable());
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

    // View Reservations (uses recursion)
    void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations.");
            return;
        }

        System.out.println("\n--- Reservations ---");
        displayRecursive(0);
    }

    // Recursive Traversal ⭐
    void displayRecursive(int index) {
        if (index >= reservations.size()) return;

        reservations.get(index).display();
        displayRecursive(index + 1);
    }

    // View Waiting List (queue)
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
}