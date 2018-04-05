package com.example.GroovySBA_ShhopManagement;

class Invoice {

    Long number
    String status
    Double balance
    Customer customer

    Invoice(Long number, String status, Double balance, Customer customer) {
        this.number = number
        this.status = status
        this.balance = balance
        this.customer = customer
    }
}

