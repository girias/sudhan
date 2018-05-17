package com.java.example.javaSBA_InvoiceProcess_SBAUpdated;

import com.java.example.JavaSBA_InvoiceProcess.InsufficientPrivilegeException;
import com.java.example.JavaSBA_InvoiceProcess.Invoice;
import com.java.example.JavaSBA_InvoiceProcess.InvoiceDAO;

import java.util.List;

public class ClerkBO extends UserBO {

    @Override
    List<Invoice> listInvoice() throws InsufficientPrivilegeException {
        throw new InsufficientPrivilegeException("Permission Denied");
    }


    @Override
    Integer createInvoice(Invoice invoice) {
        return new InvoiceDAO().invoiceCreation(invoice);
    }

    @Override
    Boolean updateInvoiceStatus(Invoice invoice, String status) throws InsufficientPrivilegeException {
        throw new InsufficientPrivilegeException("Permission Denied");
    }

    @Override
    Boolean invoicePayment(Invoice invoiceObj) throws InsufficientPrivilegeException {
        throw new InsufficientPrivilegeException("Permission Denied");
    }

}
