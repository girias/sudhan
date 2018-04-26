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

        public Long getId ()
        {
            return id;
        }


    }

}
