import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ReservationSystem system = new ReservationSystem();

        int choice = 0;

        do {
            System.out.println("\n===== RESTAURANT RESERVATION SYSTEM =====");
            System.out.println("1. Add Reservation");
            System.out.println("2. Cancel Reservation");
            System.out.println("3. View Reservations");
            System.out.println("4. View Waiting List");
            System.out.println("5. Exit");
            System.out.println("6. Show Available Tables");
            System.out.print("Enter choice: ");

            // Safe choice input
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine(); // clear buffer
            } else {
                System.out.println("Invalid input! Please enter a number.");
                sc.next(); // remove invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    int people;

                    // Safe people input
                    System.out.print("Number of people: ");
                    if (sc.hasNextInt()) {
                        people = sc.nextInt();
                        sc.nextLine(); // clear buffer
                    } else {
                        System.out.println("Invalid number!");
                        sc.next(); // remove invalid input
                        continue;
                    }

                    system.addReservation(name, people);
                    break;

                case 2:
                    System.out.print("Enter name to cancel: ");
                    String cancelName = sc.nextLine();

                    system.cancelReservation(cancelName);
                    break;

                case 3:
                    system.viewReservations();
                    break;

                case 4:
                    system.viewWaitingList();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                case 6:
                system.showAvailableTables();
                break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
