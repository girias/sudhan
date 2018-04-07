package com.java.example.Groovy_ShopManagement

class Item {
    Long id
    String name
    Double unitPrice


    Item(long id, String name, double unitPrice) {
        this.id = id
        this.name = name
        this.unitPrice = unitPrice
    }
}
