package com.groovy.example.Groovy_ReportManagement

class Asset {


    Long Number
    String Name
    String Category
    Double Price

    Long getNumber() {
        return Number
    }

    void setNumber(Long number) {
        this.Number = number
    }

    Asset(Long number, String name, String category, Double price, String status) {
        this.Number = number
        this.Name = name
        this.Category = category
        this.Price = price
        this.Status = status
    }

    String getName() {
        return Name
    }

    void setName(String name) {
        Name = name
    }

    String getCategory() {
        return Category
    }

    void setCategory(String category) {
        this.Category = category
    }

    Double getPrice() {
        return Price
    }

    void setPrice(Double price) {
        Price = price
    }

    String getStatus() {
        return Status
    }

    void setStatus(String status) {
        Status = status
    }
    String Status


}
