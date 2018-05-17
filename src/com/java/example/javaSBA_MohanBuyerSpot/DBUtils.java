package com.java.example.javaSBA_MohanBuyerSpot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils {

    public static Connection getConnection() throws ClassNotFoundException, SQLException

    {

        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = null;

        ResourceBundle rb = ResourceBundle.getBundle("com.java.example.javaSBA_MohanBuyerSpot.mysql");

        String strURL = rb.getString("db.url");

        String strUsername = rb.getString("db.username");

        String strpassword = rb.getString("db.password");

// conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/buyer_spot_DB", "root", "");

        conn = DriverManager.getConnection(strURL, strUsername, strpassword);

        return conn;

    }

}