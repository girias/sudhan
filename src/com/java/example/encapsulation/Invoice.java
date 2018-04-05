package com.java.example.encapsulation;

import java.util.Date;

public class Invoice {
    private int id;
    private String raisedBy;
    private String customerName;
    private Date startDate;
    private Date dueDate;
    private InvoiceLine invoiceLine[];

    Invoice(Integer id,String raisedBy,String customerName,Date startDate,Date dueDate){
        this.id = id;
        this.raisedBy = raisedBy;
        this.customerName = customerName;
        this.startDate = startDate;
        this.dueDate = dueDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaisedBy() {
        return raisedBy;
    }

    public void setRaisedBy(String raisedBy) {
        this.raisedBy = raisedBy;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public InvoiceLine[] getInvoiceLine() {
        return invoiceLine;
    }

    public void setInvoiceLine(InvoiceLine[] invoiceLine) {
        this.invoiceLine = invoiceLine;
    }
}
