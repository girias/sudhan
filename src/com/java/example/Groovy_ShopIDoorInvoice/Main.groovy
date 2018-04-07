package com.java.example.Groovy_ShopIDoorInvoice

class Main {

    static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))

//defining class object for InvoiceManagement
        InvoiceManagement i = new InvoiceManagement()

//reading and loading customer.xml
        String userFileName = "customer.xml"
        i.generateCustomerList(i.readFileContent(userFileName))

//reading and loading invoice.xml
        userFileName = "invoice.xml"
        i.generateInvoiceList(i.readFileContent(userFileName))

        def flag = false
        while (flag == false) {
// raeding username
            println("Enter the username")
            def username = br.readLine()
// reading password
            println("Enter the password")
            def password = br.readLine()
            def isUserExist = i.validateCustomer(username, password)
            def customer
// checking for valid user
            if (!isUserExist) {
                println("try again")
                flag = false
            } else {
                customer = i.obtainCustomer(username)
                flag = true
                while (true) {
                    println("1.List all Pending invoice\n2.Make payment\n3.exit")
                    Integer choice = br.readLine().toInteger()
                    int balance
                    if (choice == 1) {
                        def pendingInvoices = i.listAllPending(customer)
                        pendingInvoices.each {
                            pI ->
                                println "${pI.number}-${(long) (pI.balance)}"
                        }
                    } else if (choice == 2) {
// raeding valid invoice number
                        println("Enter the invoice number")
                        def number = br.readLine()?.toInteger()
                        def invoicePayment
                        def invoice = i.obtainInvoiceById(number)
                        if (invoice != null) {
// raeding amount to be paid off
                            println("Enter the amount")
                            Integer amount = Integer.parseInt(br.readLine())
                            invoicePayment = i.obtainInvoiceForPayment(number, customer)
// making payment
                            i.makePayment(invoicePayment, amount, customer)
                        } else {
                            println("invalid number")
                        }
                    } else
                        break
                }
            }
        }

    }
}
