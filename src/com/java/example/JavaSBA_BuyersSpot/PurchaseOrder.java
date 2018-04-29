package com.java.example.JavaSBA_BuyersSpot;

import java.util.Date;
import java.util.List;

public class PurchaseOrder {
    private Long id;
    private date orderDate;
    private date createdDate;
    private Integer numberOfItems;
    private Double totalAmount;
    private String customerName;
    private String mobileNumber;
    private List<orderLine> orderLineList;

    public PurchaseOrder() {
        super();
    }

    public PurchaseOrder(Date orderDate, Date createdDate, Integer numberOfItems, Double totalAmount, String customerName, String mobileNumber, List<OrderLine> orderLineList) {
        super();
        this.orderDate = orderDate;
        this.createdDate = createdDate;
        this.numberOfItems = numberOfItems;
        this.totalAmount = totalAmount;
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
        this.orderLineList = orderLineList;


    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the orderDate
     */
    public date getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return the createdDate
     */
    public date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the numberOfItems
     */
    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    /**
     * @param numberOfItems the numberOfItems to set
     */
    public void setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    /**
     * @return the totalAmount
     */
    public Double getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount the totalAmount to set
     */
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the mobileNumber
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * @param mobileNumber the mobileNumber to set
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * @return the orderLineList
     */
    public List<orderLine> getOrderLineList() {
        return orderLineList;
    }

    /**
     * @param orderLineList the orderLineList to set
     */
    public void setOrderLineList(List<orderLine> orderLineList) {
        this.orderLineList = orderLineList;
    }

}