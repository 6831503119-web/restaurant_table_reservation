package main.exception;

public class ReservationNotFoundException extends Exception {

    public ReservationNotFoundException() {
        super("Reservation not found.");
    }

    public ReservationNotFoundException(String name) {
        super("Reservation for '" + name + "' not found.");
    }

    public ReservationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
