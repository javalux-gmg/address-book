package ru.javalux.gmg.address_book.DAO;

/**
 * Created by Grigoriy Alexeev on 22 Jun 2014.
 */
public class DataAccessException extends Exception {

    public DataAccessException(Exception e) {
        super(e);
    }

    public DataAccessException(String message) {
        super(message);
    }

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataAccessException(Throwable cause) {
        super(cause);
    }

    public DataAccessException() {
    }
}
