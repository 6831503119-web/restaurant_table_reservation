package main.exception;

public class NoTablesAvailableException extends Exception {

    public NoTablesAvailableException() {
        super("No tables available at the moment.");
    }

    public NoTablesAvailableException(String message) {
        super(message);
    }

    public NoTablesAvailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
