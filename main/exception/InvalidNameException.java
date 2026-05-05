package main.exception;

public class InvalidNameException extends Exception {

    public InvalidNameException() {
        super("Invalid name provided.");
    }

    public InvalidNameException(String message) {
        super(message);
    }

    public InvalidNameException(String name, Throwable cause) {
        super("Invalid name: '" + name + "'", cause);
    }
}
