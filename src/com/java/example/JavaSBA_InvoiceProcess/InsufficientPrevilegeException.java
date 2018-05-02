package com.java.example.JavaSBA_InvoiceProcess;

public class InsufficientPrevilegeException extends Exception {
    public InsufficientPrevilegeException() {
        System.out.println("InsufficientPrevilegeException : Permission Denied");
        System.exit(1);
    }

}
