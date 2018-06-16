package com.java.example.javaSBA_InvoiceProcess_SBAUpdated;

import com.java.example.JavaSBA_InvoiceProcess.InsufficientPrivilegeException;
import com.java.example.JavaSBA_InvoiceProcess.Invoice;
import com.java.example.JavaSBA_InvoiceProcess.User;
import com.java.example.JavaSBA_InvoiceProcess.UserDAO;

import java.sql.SQLException;
import java.util.List;

abstract class UserBO {
  List<com.java.example.JavaSBA_InvoiceProcess.Invoice> invoices;
  Integer inv;
  Boolean InvoiceStatus;
  Boolean invoicePayment;

  public static com.java.example.JavaSBA_InvoiceProcess.User validateUser(
      String userName, String password) {
    UserDAO userDAO = new UserDAO();
    try {
      List<com.java.example.JavaSBA_InvoiceProcess.User> users = userDAO.getAllUser();

      for (User user : users) {
        if (user.getUserName().equalsIgnoreCase(userName) && user.getPassword().equals(password)) {
          return user;
        }
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  abstract List<com.java.example.JavaSBA_InvoiceProcess.Invoice> listInvoice()
      throws com.java.example.JavaSBA_InvoiceProcess.InsufficientPrivilegeException;

  abstract Integer createInvoice(com.java.example.JavaSBA_InvoiceProcess.Invoice invoice)
      throws com.java.example.JavaSBA_InvoiceProcess.InsufficientPrivilegeException;

  abstract Boolean updateInvoiceStatus(
      com.java.example.JavaSBA_InvoiceProcess.Invoice invoice, String status)
      throws com.java.example.JavaSBA_InvoiceProcess.InsufficientPrivilegeException;

  abstract Boolean invoicePayment(Invoice invoiceObj) throws InsufficientPrivilegeException;
}
