package com.example.Encapsulation;

public class InvoiceLine {
    private	Item item;
    private	Integer quantity;
    private	Double amount;

    InvoiceLine(Item item,int quantity,Double amount){
        this.item = item;
        this.quantity = quantity;
        this.amount = amount;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
