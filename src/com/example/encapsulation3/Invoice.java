package com.example.encapsulation3;

public class Invoice {
    private String number;
    private int total;
    private String customer;
    private InvoiceLine[] invoiceLine;

    public Invoice() {
    }

    public Invoice(String number, String customer) {
        this.number = number;
        this.customer = customer;
    }

    public Invoice(String number, int total, String customer, InvoiceLine[] invoiceLine) {
        this.number = number;
        this.total = total;
        this.customer = customer;
        this.invoiceLine = invoiceLine;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public InvoiceLine[] getInvoiceLine() {
        return invoiceLine;
    }

    public void setInvoiceLine(InvoiceLine[] invoiceLine) {
        this.invoiceLine = invoiceLine;
    }
}