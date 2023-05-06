package at.ac.fhcampuswien.fhmdb.exceptions;

public class DatabaseException extends Exception{
    public DatabaseException(){}

    public DatabaseException(String message) {

        super(message);
    }
}
