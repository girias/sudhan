package com.java.example.JavaSBA_InvoicePayment_3rdProgram;

public class Invoice {

    private int id;
    private String customerName;
    private int paymentAttempts;
    private double totalAmount;
    private double balance;
    private String status;

    public Invoice() {

    }

    public Invoice(int id, String customerName, int paymentAttempts, double totalAmount, double balance,
                   String status) {
        super();
        this.id = id;
        this.customerName = customerName;
        this.paymentAttempts = paymentAttempts;
        this.totalAmount = totalAmount;
        this.balance = balance;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getPaymentAttempts() {
        return paymentAttempts;
    }

    public void setPaymentAttempts(int paymentAttempts) {
        this.paymentAttempts = paymentAttempts;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
