package com.example.exceptionhandling;

public class CreditLimitExcption extends Exception{

    public CreditLimitExcption(String message) {
        super(message);
    }
}
