package com.mohmo.Pokemon.exception;

public class CustomJDBCException extends RuntimeException{

    public CustomJDBCException(String message, Throwable cause) {
        super(message, cause);

    }
}
