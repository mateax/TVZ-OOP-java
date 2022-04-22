package hr.java.production.exception;

public class NegativeCalculateException extends RuntimeException{

    public NegativeCalculateException(String message) {
        super(message);
    }
}
