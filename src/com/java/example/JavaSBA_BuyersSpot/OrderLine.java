package com.java.example.JavaSBA_BuyersSpot;

public class OrderLine {

  private Long id;
  private Item item;
  private PurchaseOrder purchaseOrder;
  private Double price;
  private Integer quantity;

  public OrderLine() {}

  public OrderLine(
      Long id, Item item, PurchaseOrder purchaseOrder, Double price, Integer quantity) {
    super();
    this.id = id;
    this.item = item;
    this.purchaseOrder = purchaseOrder;
    this.price = price;
    this.quantity = quantity;
  }

  /** @return the id */
  public Long getId() {
    return id;
  }

  /** @param id the id to set */
  public void setId(Long id) {
    this.id = id;
  }

  /** @return the item */
  public Item getItem() {
    return item;
  }

  /** @param item the item to set */
  public void setItem(Item item) {
    this.item = item;
  }

  /** @return the purchaseOrder */
  public PurchaseOrder getPurchaseOrder() {
    return purchaseOrder;
  }

  /** @param purchaseOrder the purchaseOrder to set */
  public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
    this.purchaseOrder = purchaseOrder;
  }

  /** @return the price */
  public Double getPrice() {
    return price;
  }

  /** @param price the price to set */
  public void setPrice(Double price) {
    this.price = price;
  }

  /** @return the quantity */
  public Integer getQuantity() {
    return quantity;
  }

  /** @param quantity the quantity to set */
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
