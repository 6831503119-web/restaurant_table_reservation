package main.exception;

public class InvalidReservationException extends Exception {

    public InvalidReservationException() {
        super("Invalid reservation data provided.");
    }

    public InvalidReservationException(String message) {
        super(message);
    }

    public InvalidReservationException(String message, Throwable cause) {
        super(message, cause);
    }
}
