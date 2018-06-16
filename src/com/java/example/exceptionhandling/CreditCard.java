package com.java.example.exceptionhandling;

public class CreditCard {

  String cardNumber;
  Double cardLimit;

  public CreditCard(String cardNumber, Double cardLimit) {
    this.cardNumber = cardNumber;
    this.cardLimit = cardLimit;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public Double getCardLimit() {
    return cardLimit;
  }

  public void setCardLimit(Double cardLimit) {
    this.cardLimit = cardLimit;
  }
}
