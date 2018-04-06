package com

class InvoiceManagement {

    /**
     * Reads file and returns file content
     * @param filename
     * @return
     */
    static String readFileContent(String filename) {
        return new File(filename).getText('UTF-8')
    }

    /**
     * Reads the xml and prepares list of customers
     * @param xmlString
     * @return
     */
    static List<Customer> generateCustomerList(String xmlString) {
//        print xmlString
        def customers = new XmlParser().parseText(xmlString)

        List<Customer> customerList = new ArrayList<>()
        Customer customer = new Customer()

        customers.customer.findAll { c ->
            customer.setId(Long.parseLong(c.@id.value[0].toString()))
            customer.setName(c.name[0].toString())
            customer.setUsername(c.username[0].toString())
            customer.setPassword(c.password[0].toString())
            customerList.add(customer)
        }
        return customerList
    }

    /**
     * Reads the xml and prepares list of invoices
     * @param xmlString
     * @return
     */
    static List<Invoice> generateInvoiceList(String xmlString) {
        def invoices = new XmlParser().parseText(xmlString)

        List<Invoice> invoiceList = new ArrayList<>()
        Invoice invoice = new Invoice()

        invoices.invoice.findAll { inv ->
            invoice.setNumber(Long.parseLong(inv.@number.value[0].toString()))
            invoice.setStatus(inv.status[0].toString())
            invoice.setBalance(Double.parseDouble(inv.balance[0].text()))
            Customer customer = new Customer()
            customer.setId(Long.parseLong(inv.customerid[0].text()))
            invoice.setCustomer(customer)
            invoiceList.add(invoice)
        }
        return invoiceList
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
