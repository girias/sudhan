package com.groovy.GroovySBA_ShhopManagement.src.com.sbashop

class GroovyMain {

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in)
        def loginSuccess = Boolean.FALSE
        def exitMenuOptions = Boolean.FALSE

        InvoiceManagement invoiceManagement = new InvoiceManagement()
        String customerXmlString = InvoiceManagement.readFileContent("C:\\\\Users\\\\giria\\\\IdeaProjects\\\\sudhan\\\\src\\\\com\\\\groovy\\\\GroovySBA_ShhopManagement\\\\src\\\\com\\\\sbashop\\\\customer.xml")
        String invoiceXmlString = InvoiceManagement.readFileContent("C:\\\\Users\\\\giria\\\\IdeaProjects\\\\sudhan\\\\src\\\\com\\\\groovy\\\\GroovySBA_ShhopManagement\\\\src\\\\com\\\\sbashop\\\\invoices.xml")

        def customerList = invoiceManagement.generateCustomerList(customerXmlString)
        println customerList.size()
        def invoiceList = invoiceManagement.generateInvoiceList(invoiceXmlString)
        println invoiceList.size()

        //map the customer object to invoice based on id
        invoiceList.forEach { invoice ->
            print invoice.getCustomer().getId()
            customerList.forEach { customer ->
                if (customer.id == invoice.customer.id) {
                    invoice.setCustomer(customer)
                }
            }
        }

        while (!loginSuccess) {
            println 'Enter the username'
            def loginUserName = scanner.nextLine()
            println 'Enter the password'
            def loginPassword = scanner.nextLine()

            for (int i = 0; i < customerList.size() - 1; i++) {
                print customerList[i].getUsername()
//                print customerList[i].getPassword()
                if (loginUserName.equalsIgnoreCase(customerList[i].getUsername()) && loginPassword == customerList[i].getPassword()) {
                    print "I am here"
                    loginSuccess = Boolean.TRUE
                } else {
                    println 'try again'
                }
            }
        }

        while (!exitMenuOptions) {
            print '1.List all Pending invoice\n 2.Make payment\n 3.exit'
            def loginMenuOption = scanner.nextInt()
            switch (loginMenuOption) {
                case 1:
                    break
                case 2:
                    break
                case 3:
                    exitMenuOptions = Boolean.TRUE
                    break
            }
        }

    }

}
