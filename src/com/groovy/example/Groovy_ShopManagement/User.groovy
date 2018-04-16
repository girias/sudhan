package com.groovy.example.Groovy_ShopManagement

class User {
    Long id
    String name
    String username
    String password
    String role

    User(long id, String name, String username, String password, String role) {
        this.id = id
        this.name = name
        this.username = username
        this.password = password
        this.role = role
    }
}
