package com.groovy.example.Groovy_ReportManagement

class User {
    Long id
    String name

    Long getId() {
        return id
    }

    User(Long id, String name, String department) {
        this.id = id
        this.name = name
        this.department = department
    }

    void setId(Long id) {
        this.id = id
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    String getDepartment() {
        return department
    }

    void setDepartment(String department) {
        this.department = department
    }
    String department

}

