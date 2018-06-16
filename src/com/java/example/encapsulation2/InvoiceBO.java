package com.java.example.encapsulation2;

public class InvoiceBO {
  public void displayUserDetailsByStatus(String status, Invoice[] invoiceArray) {
    // fill code here
    // System.out.format("%-15s %-15s %-15s", "Name", "State", "Country");
    for (Invoice invoice : invoiceArray) {
      if (invoice.getStatus().equalsIgnoreCase(status)) {
        System.out.format(
            "\n%-15s %-15s %-15s",
            invoice.getCustomer().getName(),
            invoice.getCustomer().getState(),
            invoice.getCustomer().getCountry());
      }
    }
  }

  public double getTotalInvoiceValue(String userName, Invoice[] invoiceArray) {
    // fill code here
    Double sum = 0.0;
    for (Invoice invoice : invoiceArray) {
      if (invoice.getCreatedBy().equalsIgnoreCase(userName)) {
        sum += invoice.getTotal();
      }
    }
    return sum;
  }
}
