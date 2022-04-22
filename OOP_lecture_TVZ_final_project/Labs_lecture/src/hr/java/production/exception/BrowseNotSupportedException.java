package hr.java.production.exception;

public class BrowseNotSupportedException extends RuntimeException{

    public BrowseNotSupportedException(String message) {

        super(message);
    }
}
