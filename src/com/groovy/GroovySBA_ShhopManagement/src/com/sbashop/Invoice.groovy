package com.groovy.GroovySBA_ShhopManagement.src.com.sbashop

class Invoice {

    long number
    String status
    Double balance
    Customer customer

    long getNumber() {
        return number
    }

    void setNumber(long number) {
        this.number = number
    }

    String getStatus() {
        return status
    }

    void setStatus(String status) {
        this.status = status
    }

    Double getBalance() {
        return balance
    }

    void setBalance(Double balance) {
        this.balance = balance
    }

    Customer getCustomer() {
        return customer
    }

    void setCustomer(Customer customer) {
        this.customer = customer
    }
}
