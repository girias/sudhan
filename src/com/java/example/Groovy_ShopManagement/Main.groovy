package com.java.example.Groovy_ShopManagement

class Main {

    static void main(String[] args) {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in))
        def purchaseOrderList = []
        def userObject
        PurchaseOrder PO

        ShopDoorManagement s = new ShopDoorManagement()

        String fileData = s.readFileContent("User.xml")
        s.loadAllUsers(fileData)

        fileData = s.readFileContent("Item.xml")
        s.loadAllItems(fileData)

        println "Login:"

        while (true) {
            println "Username:"
            def userName = buf.readLine()
            println "Password:"
            def password = buf.readLine()
            def isValidUser = s.validateUser(userName, password)
            if (isValidUser)
                break
            else
                println "Username or password is wrong!.try again.."
        }
        def total = 0
        def orderLineList = []
        while (true) {
            println "Item id:"
            def itemId = Long.parseLong(buf.readLine())

            def item = s.obtainItem(itemId)
            if (item != null) {
                println "Quantity:"
                def quantity = Integer.parseInt(buf.readLine())
                purchaseOrderList << new OrderLine(item, quantity, s.computeItemPrice(item, quantity))
            } else {
                println "Item with " + itemId + " not found."
            }
            println "Do you want to add one more item?(Yes/No)"
            def ch = buf.readLine()
            if (ch.equalsIgnoreCase("No"))
                break
        }
        println "Order created successfully."
        println "Purchase order 1"
        PO = new PurchaseOrder(1, "Created", purchaseOrderList)

        println PO.toString()
        PO.orderLineList.each { oL ->
            println oL.toString()
        }
        println "Total Purchase order: " + s.computeTotalPrice(PO)
    }
}