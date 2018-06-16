package com.java.example.JavaSBA_BuyersSpot;

public class InsufficientQuantityException extends Exception {
  public InsufficientQuantityException(String message) {
    System.out.println(message);
  }
}
