package main.exception;

public class InvalidPeopleException extends Exception {

    public InvalidPeopleException() {
        super("Invalid number of people provided.");
    }

    public InvalidPeopleException(String message) {
        super(message);
    }

    public InvalidPeopleException(int people) {
        super("Number of people must be greater than 0, got: " + people);
    }

    public InvalidPeopleException(String message, Throwable cause) {
        super(message, cause);
    }
}
