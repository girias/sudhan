package com.java.example.GroovySBA_ShhopManagement

class InvoiceManagement {
    public static def customerList = []
    public static def invoiceList = []

    def readFileContent(filename) {
        File file = new File(filename)
        String xmlString = file.text
        return xmlString
    }

    def generateCustomerList(xmlString) {
        def customers = new XmlSlurper().parseText(xmlString)
        customers.customer.each {
            u ->
                    customerList.add(new Customer(Long.parseLong(u. @id.text()),
            u.name.text(), u.username.text(), u.password.text()))
        }
        customerList
    }

    def generateInvoiceList(xmlString) {
        def invoiceDoc = new XmlSlurper().parseText(xmlString)
        invoiceDoc.invoice.each {
            invoiceObj ->
                    def customerIns = customerList ?.find {
                it ?.id.toInteger() == invoiceObj.customerid.toInteger()
            }
            if (customerIns != null) {
                invoiceList.add(new Invoice(Long.parseLong(invoiceObj. @number.text()),
                invoiceObj.status.text(), Double.parseDouble(invoiceObj.balance.text()), customerIns as Customer))
            }
        }
        invoiceList
    }

    def validateCustomer(username, password) {

        boolean value = false
        customerList.each {
            if ((it.username.equals(username)) && (it.password.equals(password))) {
                value = true

            }
        }
        return value
    }

    def obtainCustomer(username) {
        def customer = customerList.find {
            it.username.equals(username)
        }
        return customer
    }

    List<Invoice> listAllPending(customer) {
        def pendingInvoiceListForCustomer = []
        pendingInvoiceListForCustomer = invoiceList.findAll {
            (it.customer.id == customer.id) && (it.status.equalsIgnoreCase("pending"))
        }
        return pendingInvoiceListForCustomer
    }

    def obtainInvoiceById(invoiceId) {
        def invoice
        invoice = invoiceList.find {
            it.number == invoiceId
        }
        return invoice
    }

    def obtainInvoiceForPayment(invoiceId, customer) {
        def invoice
        invoiceList.each {
            if ((it.number == invoiceId) && (it.customer.id == customer.id)) {
                invoice = it
            }
        }
        return invoice
    }

    def makePayment(invoice, amount, customer) {
        Integer balance1 = invoice.balance.toInteger()
        if (invoice != null && customer != null) {
            if ((invoice.status.equalsIgnoreCase("pending"))) {
                if (balance1 != 0) {
                    balance1 -= amount
                    invoice.balance = balance1
                    if (balance1 == 0) {
                        invoice.status = "Completed"
                    }
                    return true
                }

            } else {
                return false
            }
        }
    }
}