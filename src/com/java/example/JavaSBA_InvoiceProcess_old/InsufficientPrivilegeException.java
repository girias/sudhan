package com.java.example.JavaSBA_InvoiceProcess_old;

public class InsufficientPrivilegeException extends Exception {
  public InsufficientPrivilegeException(String message) {
    System.out.println("InsufficientPrivilegeException :" + message);
    // System.exit(1);
  }
}
