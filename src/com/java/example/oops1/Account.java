package com.java.example.oops1;

import java.util.Arrays;

public class Account {
    String username;
    String password;
    int cvv;
    byte[] fingerPrint;

    public Account() {
    }

    public Account(String username, String password, int cvv, byte[] fingerPrint) {
        this.username = username;
        this.password = password;
        this.cvv = cvv;
        this.fingerPrint = fingerPrint;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public byte[] getFingerPrint() {
        return fingerPrint;
    }

    public void setFingerPrint(byte[] fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    public Boolean authentication(String username, String password) {
        //fill the code

        return getUsername().equalsIgnoreCase(username) && getPassword().equalsIgnoreCase(password);
    }

    public Boolean authentication(String username, int cvv) {
        //fill the code
        return getUsername().equalsIgnoreCase(username) && cvv == getCvv();
    }

    public Boolean authentication(byte[] fingerPrint) {
        //fill the code
        return Arrays.equals(getFingerPrint(), fingerPrint);
    }

}

