package com.tpe.HandlerExceptionResolver;

public class DatabaseException extends RuntimeException {

    public DatabaseException(String message) {
        super(message);
    }
}