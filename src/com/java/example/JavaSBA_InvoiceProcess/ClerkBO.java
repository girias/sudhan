package com.java.example.JavaSBA_InvoiceProcess;

import java.util.List;

public class ClerkBO extends UserBO {
    public List<Invoice> listInvoice() throws InsufficientPrivilegeException {
        throw new InsufficientPrivilegeException();
    }

    public Integer createInvoice(Invoice invoice) {
        InvoiceDAO invoiceDao = new InvoiceDAO();
        Integer inv = invoiceDao.invoiceCreation(invoice);
        return inv;
    }

    public Boolean updateInvocieStatus(Invoice invoice, String status) throws InsufficientPrivilegeException {
        throw new InsufficientPrivilegeException();
    }

    public Boolean invoicePayment(Invoice invoiceObj) throws InsufficientPrivilegeException {
        throw new InsufficientPrivilegeException();
    }

}
