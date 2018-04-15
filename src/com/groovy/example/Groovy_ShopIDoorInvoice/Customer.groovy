package com.groovy.example.Groovy_ShopIDoorInvoice

class Customer {
    Long id
    String name
    String username
    String password

    Customer(long id, String name, String username, String password) {
        this.id = id
        this.name = name
        this.username = username
        this.password = password
    }
}