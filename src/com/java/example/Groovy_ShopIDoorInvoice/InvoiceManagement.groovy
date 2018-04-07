package com.java.example.Groovy_ShopIDoorInvoice

class InvoiceManagement {
    public static def customerList = []
    public static def invoiceList = []

//This method is used to read the content from the file and return that file content as string.
    String readFileContent(String filename) {
        def xmlString = new File(filename).text
        return xmlString
    }

// This method is used to read that xmlString(xml file content)
// and generate the Customer list from that xmlString. The method returns the Customer list.
    def generateCustomerList(xmlString) {
        def customers = new XmlSlurper().parseText(xmlString)
        customers.customer.each { u ->
            customerList << new Customer(
                    Long.parseLong(u.@id.text()),
                    u.name.text(),
                    u.username.text(),
                    u.password.text()
            )
        }
    }

//This method is used to read that xmlString(xml file content)
//and generate the invoice list from that xmlString. The method returns the invoice list.
    def generateInvoiceList(String xmlString) {
        def invoiceDoc = new XmlSlurper().parseText(xmlString)
        invoiceDoc.invoice.each { invoiceObj ->
            def customerIns = customerList.find { it.id.toInteger() == invoiceObj.customerid.toInteger() }
            invoiceList << new Invoice(
                    Long.parseLong(invoiceObj.@number.text()),
                    invoiceObj.status.text(),
                    Double.parseDouble(invoiceObj.balance.text()),
                    customerIns)
        }
    }

//This method is used to check if the Customer gives a valid username and password,
//If valid, then method returns true, otherwise returns false
    Boolean validateCustomer(String username, String password) {
        Customer customer = customerList.find { cL -> cL.username == username && cL.password == password }
        if (customer == null) {
            return false
        } else {
            return true
        }
    }

//This method is used to find the user using the given username and returns the user object.
    def obtainCustomer(String username) {
        def customer
        customer = customerList.find { cL -> cL.username == username }
        return customer
    }

//This method is used to return the list of invoices which are pending for a particular customer.
    List<Invoice> listAllPending(customer) {
        def pendingInvoiceListForCustomer = []
        pendingInvoiceListForCustomer = invoiceList.findAll { iL -> iL.customer.id == customer.id && iL.status == "pending" }
        return pendingInvoiceListForCustomer
    }

//This method is used to find a specific invoice using the given invoice number from the invoice list.
//If the specific invoice is available, then method returns that invoice object, otherwise returns null.
    def obtainInvoiceById(invoiceId) {
        def invoice
        invoice = invoiceList.find { iL -> iL.number == invoiceId }
        return invoice
    }

//This method is used to get all the pending invoice for the particular customer.
    def obtainInvoiceForPayment(invoiceId, customer) {
        def invoice
        invoice = invoiceList.find { iL -> iL.customer.id == customer.id && iL.number == invoiceId && iL.status == "pending" }
        return invoice
    }

//This method lets a Customer to make payment against a particular pending invoice.
//If the payment is successful, then method returns true, otherwise returns false.
    def makePayment(invoice, amount, customer) {
        Integer balance = invoice.balance.toInteger()
        if (invoice != null && customer != null) {
            invoice.balance = balance - amount
            if (invoice.balance == 0) {
                invoice.status = "Completed"
            }
            return true
        } else {
            return false
        }
    }
}
