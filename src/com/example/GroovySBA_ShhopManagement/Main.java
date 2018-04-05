package com.example.GroovySBA_ShhopManagement;

class Main {

    static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        InvoiceManagement i = new InvoiceManagement()

        String userFileName = "src\\customer.xml";
        String customerfileContent = i.readFileContent(userFileName)
        i.generateCustomerList(customerfileContent)
        userFileName = "src\\invoice.xml";
        String invoiceFileContent = i.readFileContent(userFileName)
        i.generateInvoiceList(invoiceFileContent)
        def flag = false

        while (flag == false) {
            println("Enter the username")
            def username = br.readLine()
            println("Enter the password")
            def password = br.readLine()

            def isUserExist
            def customer
            isUserExist = i.validateCustomer(username, password)

            if (!isUserExist) {
                println("try again");
                flag = false
            } else {
                customer = i.obtainCustomer(username)
                flag = true
                while (true) {
                    println("1.List all Pending invoice\n2.Make payment\n3.exit");
                    Integer choice = br.readLine().toInteger()
                    int balance;
                    if (choice == 1) {
                        println "Invoice number - Balance"
                        if (customer != null) {
                            def invList = i.listAllPending(customer)
                            if (invList != null) {
                                invList.each {
                                    println("${it.number}-${it.balance.intValue()}")
                                }
                            } else {
                                println("No invoices for that customer")
                            }
                        } else {
                            println("No Such user is present")
                        }
                    } else if (choice == 2) {
                        println("Enter the invoice number")
                        def number = br.readLine() ?.toInteger()
                        def invoicePayment
                        invoicePayment = i.obtainInvoiceById(number)
                        if (invoicePayment != null) {
                            println("Enter the amount")
                            Integer amount = Integer.parseInt(br.readLine())
                            invoicePayment = i.obtainInvoiceForPayment(number, customer)
                            if (invoicePayment != null) {
                                i.makePayment(invoicePayment, amount, customer)
                            }
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