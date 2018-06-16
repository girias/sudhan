package com.java.example.JavaSBA_InvoicePayment_3rdProgram;

import java.util.Date;

public class ChequePayment extends Payment {

  private String bankName;
  private String checkNumber;
  private Date checkDate;

  public ChequePayment(
      String accountHolderName,
      double amount,
      String bankName,
      String checkNumber,
      Date checkDate) {
    super(accountHolderName, amount);
    this.bankName = bankName;
    this.checkNumber = checkNumber;
    this.checkDate = checkDate;
  }

  public ChequePayment() {
    // TODO Auto-generated constructor stub
  }

  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public String getCheckNumber() {
    return checkNumber;
  }

  public void setCheckNumber(String checkNumber) {
    this.checkNumber = checkNumber;
  }

  public Date getCheckDate() {
    return checkDate;
  }

  public void setCheckDate(Date checkDate) {
    this.checkDate = checkDate;
  }

  @Override
  public Double calculateTotalAmount() throws InvalidPaymentException {
    // TODO Auto-generated method stub
    if (!checkNumber.matches("[0-9]+")) throw new InvalidPaymentException("Invalid Cheque Details");

    if (amount < 0) throw new InvalidPaymentException("Invalid Cheque Details");

    return (amount + 250);
  }
}
