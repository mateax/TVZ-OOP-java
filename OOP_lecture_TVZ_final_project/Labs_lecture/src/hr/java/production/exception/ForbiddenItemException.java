package hr.java.production.exception;

public class ForbiddenItemException extends RuntimeException{
    public ForbiddenItemException() {
    }

    public ForbiddenItemException(String message) {
        super(message);
    }

    public ForbiddenItemException(String message, Throwable cause) {
        super(message, cause);
    }

    public ForbiddenItemException(Throwable cause) {
        super(cause);
    }
}
