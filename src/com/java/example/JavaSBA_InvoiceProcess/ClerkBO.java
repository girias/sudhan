package com.java.example.JavaSBA_InvoiceProcess;

import java.util.List;

public class ClerkBO extends UserBO {
    public List<Invoice> listInvoice() throws InsufficientPrevilegeException {
        throw new InsufficientPrevilegeException();
    }

    public Integer createInvoice(Invoice invoice) {
        InvoiceDAO invoiceDao = new InvoiceDAO();
        Integer inv = invoiceDao.invoiceCreation(invoice);
        return inv;
    }

    public Boolean updateInvocieStatus(Invoice invoice, String status) throws InsufficientPrevilegeException {
        throw new InsufficientPrevilegeException();
    }

    public Boolean invoicePayment(Invoice invoiceObj) throws InsufficientPrevilegeException {
        throw new InsufficientPrevilegeException();
    }

}
