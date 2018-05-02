package com.java.example.JavaSBA_InvoiceProcess;

public class UserBO {
    List<Invoice> invoices;
    Integer inv;
    Boolean InvoiceStatus;
    Boolean invoicePayment;

    List<Invoice> listInvoice() throws InsufficientPrevilegeException {
        return invoices;
    }

    Integer createInvoice(Invoice invoice) throws InsufficientPrevilegeException {
        return inv;
    }

    Boolean updateInvoiceStatus(Invoice invoice, String status) {
        return InvoiceStatus;
    }

    Boolean invoicePayment(Invoice invoiceObj) throws InsufficientPrevilegeException {
        return invoicePayment;
    }
}