package com.java.example.JavaSBA_InvoiceProcess;

import java.util.ArrayList;
import java.util.List;

public class PaymentReleaserBO extends UserBO {
    public List<Invoice> listInvoice() {
        InvoiceDAO invoiceDao = new InvoiceDAO();
        List<Invoice> invoices = invoiceDao.getAllInvoiceList();
        List<Invoice> pendInvoices = new ArrayList<Invoice>();
        for (Invoice inv : invoices) {
            if (inv.getStatus().equalsIgnoreCase("Pending")) {
                pendInvoices.add(inv);
            }
        }
        return pendInvoices;
    }

    public Integer createInvoice(Invoice invoice) throws InsufficientPrevilegeException {
        throw new InsufficientPrevilegeException();
    }

    public Boolean updateInvocieStatus(Invoice invoice, String status) throws InsufficientPrevilegeException {
        throw new InsufficientPrevilegeException();
    }

    public Boolean invoicePayment(Invoice invoiceObj) {
        InvoiceDAO invoiceDao = new InvoiceDAO();
        invoiceDao.invoicePayment(invoiceObj);
        return true;
    }
}
