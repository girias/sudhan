package com.java.example.Collections;

import java.util.Date;

public class Shipment {
  Integer id;
  String status;
  Date dispatchedDate;
  Date receivedDate;

  public Shipment(int id, String status, Date dispatchedDate, Date receivedDate) {
    this.id = id;
    this.status = status;
    this.dispatchedDate = dispatchedDate;
    this.receivedDate = receivedDate;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getStatus() {

    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Date getReceivedDate() {
    return receivedDate;
  }

  public void setReceivedDate(Date receivedDate) {
    this.receivedDate = receivedDate;
  }

  public Date getDispatchedDate() {

    return dispatchedDate;
  }

  public void setDispatchedDate(Date dispatchedDate) {
    this.dispatchedDate = dispatchedDate;
  }
}
