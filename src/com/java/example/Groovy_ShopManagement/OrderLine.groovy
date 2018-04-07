package com.java.example.Groovy_ShopManagement

class OrderLine {
    Item item
    Integer quantity
    Double price

    OrderLine() {}

    OrderLine(Item item, int quantity, double price) {
        this.item = item
        this.quantity = quantity
        this.price = price
    }

    String toString() {
        "Name : ${item.name} | Quantity : ${quantity} | Price : ${price}"
    }
}
