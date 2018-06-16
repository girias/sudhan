package com.java.example.exceptionhandling;

public class Invoice {
  String invoiceNumber;
  String totalAmount;
  Integer attempt;

  public Invoice(String invoiceNumber, String totalAmount, Integer attempt) {
    this.invoiceNumber = invoiceNumber;
    this.totalAmount = totalAmount;
    this.attempt = attempt;
  }

  public String getInvoiceNumber() {
    return invoiceNumber;
  }

  public void setInvoiceNumber(String invoiceNumber) {
    this.invoiceNumber = invoiceNumber;
  }

  public String getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(String totalAmount) {
    this.totalAmount = totalAmount;
  }

  public Integer getAttempt() {
    return attempt;
  }

  public void setAttempt(Integer attempt) {
    this.attempt = attempt;
  }
}
