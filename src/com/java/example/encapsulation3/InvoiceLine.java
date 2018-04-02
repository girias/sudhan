package com.java.example.encapsulation3;

public class InvoiceLine {
    private Item item;
    private Invoice invoice;
    private int amount;
    private int price;
    private int quantity;

    public InvoiceLine(Item item, int quantity, Invoice invoice) {
        this.item = item;
        this.quantity = quantity;
        this.invoice = invoice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

