package com.java.example.JavaSBA_InvoiceProcess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO {
    List<User> users;

    public UserDAO() {
        users = new ArrayList<User>();
    }

    public List<User> getAllUser() throws SQLException {
        Connection dbconn = DbConnection.getConnection();
        Statement stmt = dbconn.createStatement();
        String sql = "Select id,username, password, address , role from user:";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            User u = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("address"), rs.getString("role"))
            users.add(u);
        }
        return users;

    }
}
