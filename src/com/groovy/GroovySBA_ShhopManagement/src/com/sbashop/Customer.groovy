package com.groovy.GroovySBA_ShhopManagement.src.com.sbashop

class Customer {

    long id
    String name
    String username
    String password

    long getId() {
        return id
    }

    void setId(long id) {
        this.id = id
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    String getUsername() {
        return username
    }

    void setUsername(String username) {
        this.username = username
    }

    String getPassword() {
        return password
    }

    void setPassword(String password) {
        this.password = password
    }
}
