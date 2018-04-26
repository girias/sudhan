package com.groovy.example.Groovy_ReportManagement

class Log {
    Asset asset
    User user
    String action

    Log(Asset asset, User user, String action, Date date) {
        this.asset = asset
        this.user = user
        this.action = action
        this.date = date
    }
    Asset getAsset() {

        return asset
    }
    void setAsset(Asset asset) {
        this.asset = asset
    }
    User getUser() {
        return user
    }
    void setUser(User user) {
        this.user = user
    }
    String getAction() {
        return action
    }

    void setAction(String action) {
        this.action = action
    }

    Date getDate() {
        return date
    }

    void setDate(Date date) {
        this.date = date
    }
    Date date

}
