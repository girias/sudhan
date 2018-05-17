package com.java.example.javaSBA_InvoiceProcess_SBAUpdated;

import com.java.example.JavaSBA_InvoiceProcess.DbConnection;
import com.java.example.JavaSBA_InvoiceProcess.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    List<com.java.example.JavaSBA_InvoiceProcess.User> users;

    public UserDAO() {
        users = new ArrayList<com.java.example.JavaSBA_InvoiceProcess.User>();
    }

    public List<com.java.example.JavaSBA_InvoiceProcess.User> getAllUser() throws SQLException {
        Connection dbconn = DbConnection.getConnection();
        Statement stmt = dbconn.createStatement();
        String sql = "select id,username,password,address,role from user";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            com.java.example.JavaSBA_InvoiceProcess.User u = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("address"), rs.getString("role"));
            users.add(u);
        }
        return users;

    }
}
