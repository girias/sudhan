package com.java.example.javaSBA_MohanBuyerSpot;

import java.util.Date;
import java.util.List;

public class PurchaseOrder {

  private long id;
  private java.util.Date orderDate;
  private java.util.Date createdDate;
  private int numberOfItems;
  private double totalAmount;
  private String customerName;
  private String mobileNumber;
  private List<OrderLine> orderLineList;

  public PurchaseOrder(
      long id,
      Date orderDate,
      Date createdDate,
      int numberOfItems,
      double totalAmount,
      String customerName,
      String mobileNumber,
      List<OrderLine> orderLineList) {

    super();

    this.id = id;

    this.orderDate = orderDate;

    this.createdDate = createdDate;

    this.numberOfItems = numberOfItems;

    this.totalAmount = totalAmount;

    this.customerName = customerName;

    this.mobileNumber = mobileNumber;

    this.orderLineList = orderLineList;
  }

  public PurchaseOrder() {

    super();
  }

  public long getId() {

    return id;
  }

  public void setId(long id) {

    this.id = id;
  }

  public java.util.Date getOrderDate() {

    return orderDate;
  }

  public void setOrderDate(java.util.Date orderDate) {

    this.orderDate = orderDate;
  }

  public java.util.Date getCreatedDate() {

    return createdDate;
  }

  public void setCreatedDate(java.util.Date createdDate) {

    this.createdDate = createdDate;
  }

  public int getNumberOfItems() {

    return numberOfItems;
  }

  public void setNumberOfItems(int numberOfItems) {

    this.numberOfItems = numberOfItems;
  }

  public double getTotalAmount() {

    return totalAmount;
  }

  public void setTotalAmount(double totalAmount) {

    this.totalAmount = totalAmount;
  }

  public String getCustomerName() {

    return customerName;
  }

  public void setCustomerName(String customerName) {

    this.customerName = customerName;
  }

  public String getMobileNumber() {

    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {

    this.mobileNumber = mobileNumber;
  }

  public List<OrderLine> getOrderLineList() {

    return orderLineList;
  }

  public void setOrderLineList(List<OrderLine> orderLineList) {

    this.orderLineList = orderLineList;
  }
}
