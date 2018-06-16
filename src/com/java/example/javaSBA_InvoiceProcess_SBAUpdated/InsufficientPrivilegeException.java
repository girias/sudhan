package com.java.example.javaSBA_InvoiceProcess_SBAUpdated;

public class InsufficientPrivilegeException extends Exception {
  public InsufficientPrivilegeException(String message) {
    System.out.println("InsufficientPrivilegeException :" + message);
    // System.exit(1);
  }
}
