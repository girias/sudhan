package com.java.example.JavaSBA_InvoiceProcess;

public class InsufficientPrivilegeException extends Exception {
    public InsufficientPrivilegeException() {
        System.out.println("InsufficientPrivilegeException : Permission Denied");
        System.exit(1);
    }

}
