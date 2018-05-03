package com.java.example.InvoicePayment;

abstract class Payment {
    private String accountHolderName;
    private Double amount;


    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public abstract Double calculateTotalAmount();

}
