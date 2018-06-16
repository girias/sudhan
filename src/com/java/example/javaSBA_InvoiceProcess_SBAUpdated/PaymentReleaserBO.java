package com.java.example.javaSBA_InvoiceProcess_SBAUpdated;

import com.java.example.JavaSBA_InvoiceProcess.InsufficientPrivilegeException;
import com.java.example.JavaSBA_InvoiceProcess.Invoice;
import com.java.example.JavaSBA_InvoiceProcess.InvoiceDAO;

import java.util.ArrayList;
import java.util.List;

public class PaymentReleaserBO extends UserBO {

  @Override
  public List<com.java.example.JavaSBA_InvoiceProcess.Invoice> listInvoice() {
    com.java.example.JavaSBA_InvoiceProcess.InvoiceDAO invoiceDao =
        new com.java.example.JavaSBA_InvoiceProcess.InvoiceDAO();
    List<com.java.example.JavaSBA_InvoiceProcess.Invoice> invoices = invoiceDao.getAllInvoiceList();
    List<com.java.example.JavaSBA_InvoiceProcess.Invoice> pendInvoices =
        new ArrayList<com.java.example.JavaSBA_InvoiceProcess.Invoice>();
    for (com.java.example.JavaSBA_InvoiceProcess.Invoice inv : invoices) {
      if (inv.getStatus().equalsIgnoreCase("Pending")) {
        pendInvoices.add(inv);
      }
    }
    return pendInvoices;
  }

  @Override
  public Integer createInvoice(com.java.example.JavaSBA_InvoiceProcess.Invoice invoice)
      throws com.java.example.JavaSBA_InvoiceProcess.InsufficientPrivilegeException {
    throw new com.java.example.JavaSBA_InvoiceProcess.InsufficientPrivilegeException(
        "Permission Denied");
  }

  @Override
  Boolean updateInvoiceStatus(
      com.java.example.JavaSBA_InvoiceProcess.Invoice invoice, String status)
      throws com.java.example.JavaSBA_InvoiceProcess.InsufficientPrivilegeException {
    throw new InsufficientPrivilegeException("Permission Denied");
  }

  @Override
  public Boolean invoicePayment(Invoice invoiceObj) {
    com.java.example.JavaSBA_InvoiceProcess.InvoiceDAO invoiceDao = new InvoiceDAO();
    invoiceDao.invoicePayment(invoiceObj);
    return true;
  }
}
