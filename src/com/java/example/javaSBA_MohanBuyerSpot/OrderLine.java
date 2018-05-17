package com.java.example.javaSBA_MohanBuyerSpot;

public class OrderLine {

//id,item,purchaseOrder,price,quantity

    private long id;
    private Item item;
    private PurchaseOrder purchaseOrder;
    private double price;
    private int quantity;

    public OrderLine() {

        super();

    }

    public OrderLine(long id, Item item, double price,

                     int quantity) {

        super();

        this.id = id;

        this.item = item;

        this.price = price;

        this.quantity = quantity;

    }

    public long getId() {

        return id;

    }

    public void setId(long id) {

        this.id = id;

    }

    public Item getItem() {

        return item;

    }

    public void setItem(Item item) {

        this.item = item;

    }

    public PurchaseOrder getPurchaseOrder() {

        return purchaseOrder;

    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {

        this.purchaseOrder = purchaseOrder;

    }

    public double getPrice() {

        return price;

    }

    public void setPrice(double price) {

        this.price = price;

    }

    public int getQuantity() {

        return quantity;

    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;

    }

}
