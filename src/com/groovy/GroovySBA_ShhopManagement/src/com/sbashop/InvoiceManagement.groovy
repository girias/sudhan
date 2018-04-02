package com.groovy.GroovySBA_ShhopManagement.src.com.sbashop

class InvoiceManagement {

    String readFileContent(String filename) {
        return new File(filename)
    }

    /**
     * Reads the xml and prepares list of customers
     * @param xmlString
     * @return
     */
    List<Customer> generateCustomerList(String xmlString) {
        return null
    }

    /**
     * Reads the xml and prepares list of invoices
     * @param xmlString
     * @return
     */
    List<Invoice> generateInvoiceList(String xmlString) {
        return null
    }

    Boolean validateCustomer(String username, String password) {
        return true
    }

    Customer obtainCustomer(String username) {

    }

    List<Invoice> listAllPending(Customer customer) {

    }

    Invoice obtainInvoiceById(Long invoicenumber) {

    }

    Boolean makePayment(Invoice invoice, Double amount, Customer customer) {
        return true
    }

    Invoice obtainInvoiceForPayment(Long invoicenumber, Customer customer) {

    }
}
