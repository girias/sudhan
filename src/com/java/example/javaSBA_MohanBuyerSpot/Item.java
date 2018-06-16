package com.java.example.javaSBA_MohanBuyerSpot;

public class Item {

  private long id;
  private String name;
  private int availableQuantity;
  private double price;

  public Item(long id, String name, int availableQuantity, double price) {

    super();

    this.id = id;

    this.name = name;

    this.availableQuantity = availableQuantity;

    this.price = price;
  }

  public Item() {

    super();
  }

  public long getId() {

    return id;
  }

  public void setId(long id) {

    this.id = id;
  }

  public String getName() {

    return name;
  }

  public void setName(String name) {

    this.name = name;
  }

  public int getAvailableQuantity() {

    return availableQuantity;
  }

  public void setAvailableQuantity(int availableQuantity) {

    this.availableQuantity = availableQuantity;
  }

  public double getPrice() {

    return price;
  }

  public void setPrice(double price) {

    this.price = price;
  }
}
