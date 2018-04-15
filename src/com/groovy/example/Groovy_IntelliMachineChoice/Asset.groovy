package com.groovy.example.Groovy_IntelliMachineChoice

class Asset {

    long number
    String name
    Category category
    double price
    String status

    Asset(long number, String name, Category category, double price) {
        this.number = number
        this.name = name
        this.category = category
        this.price = price
    }
}
