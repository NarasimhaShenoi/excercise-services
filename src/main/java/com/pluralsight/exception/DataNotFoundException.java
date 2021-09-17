package com.pluralsight.exception;

public class DataNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -343999999992L;

    public DataNotFoundException(String message) {
        super(message);
    }
}
