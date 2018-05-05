package com.java.example.JavaSBA_InvoicePayment_3rdProgram;

public abstract class Payment {

    protected String accountHolderName;
    protected double amount;

    public Payment(String accountHolderName, double amount) {
        super();
        this.accountHolderName = accountHolderName;
        this.amount = amount;
    }

    public Payment() {
        // TODO Auto-generated constructor stub
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public abstract Double calculateTotalAmount() throws InvalidPaymentException;

}
