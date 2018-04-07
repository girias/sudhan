package com.java.example.Groovy_ShopManagement

class ShopDoorManagement {

    public static def userList = []
    public static def itemList = []


    String readFileContent(String filename) {
        def xmlString
        xmlString = new File(filename).text
        return xmlString
    }

    void loadAllUsers(String xmlString) {
        def users = new XmlSlurper().parseText(xmlString)
        users.user.each { user ->
            userList.add(new User(Long.parseLong(user.@id.text()), user.name.text(),
                    user.username.text(), user.password.text(), user.role.text()))
        }
    }

    void loadAllItems(String xmlString) {
        def items = new XmlSlurper().parseText(xmlString)
        items.item.each { item ->
            itemList.add(new Item(Long.parseLong(item.@id.text()), item.name.text(), Double.parseDouble(item.unitprice.text())))
        }
    }

    boolean validateUser(uname, passwd) {
        boolean val = false
        def x = userList.find { u -> u.username == uname && u.password == passwd }
        if (x != null) {
            return true
        } else {
            return val
        }
    }

    Item obtainItem(itemId) {
        def item
        item = itemList.find { i -> i.id == itemId }
        if (item != null) {
            return item
        } else {
            return null
        }
    }

    double computeItemPrice(item, quantity) {
        double price
        price = item.unitPrice * quantity
        return price
    }

    double computeTotalPrice(purchaseOrder) {
        def totalPrice = 0
        purchaseOrder.orderLineList.each { oL ->
            totalPrice = totalPrice + oL.price
        }
        return (totalPrice)
    }

    def validateItem(itemId) {
        def item
        item = itemList.find { i -> i.id == Long.parseLong(itemId) }
        if (item != null) {
            return item
        } else {
            return null
        }
    }
}
