package com.java.example.JavaSBA_InvoiceProcess;

import java.util.List;

abstract class UserBO {
    List<Invoice> invoices;
    Integer inv;
    Boolean InvoiceStatus;
    Boolean invoicePayment;

    List<Invoice> listInvoice() throws InsufficientPrivilegeException {
        return invoices;
    }

    Integer createInvoice(Invoice invoice) throws InsufficientPrivilegeException {
        return inv;
    }

    Boolean updateInvoiceStatus(Invoice invoice, String status) {
        return InvoiceStatus;
    }

    Boolean invoicePayment(Invoice invoiceObj) throws InsufficientPrivilegeException {
        return invoicePayment;
    }
}