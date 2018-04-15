package com.groovy.example.Groovy_ReportManagement

class Category {
    Long id
    String name

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    String getName() {
        return name
    }

    Category(Long id, String name) {
        this.id = id
        this.name = name
    }

    void setName(String name) {
        this.name = name
    }

}
