package org.squidmin.springboot.postgresql.exception;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(String message) {
        super(message);
    }

}
