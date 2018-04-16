package com.groovy.example.Groovy_IntelliAssetManagement

class Asset {

    Long id
    String category
    String type
    Double price
    User user
    Boolean availability


    Asset(long id, String category, String type, double price, User user, Boolean availability) {

        this.id = id
        this.category = category
        this.type = type
        this.price = price
        this.user = user
        this.availability = availability
    }
}