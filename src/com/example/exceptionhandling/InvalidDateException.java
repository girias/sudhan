package com.example.exceptionhandling;

public class InvalidDateException extends Exception {

    public InvalidDateException (String message) {
        super(message);
    }
}
