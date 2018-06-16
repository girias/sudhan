package com.java.example.JavaSBA_InvoicePayment_3rdProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DbConnection {

  public static Connection getConnection() {

    ResourceBundle rb =
        ResourceBundle.getBundle("com.java.example.JavaSBA_InvoicePayment_3rdProgram.mysql");
    String url = rb.getString("db.url");
    String username = rb.getString("db.username");
    String password = rb.getString("db.password");

    // fill the code
    Connection conn = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(url, username, password);
      //	        System.out.println("Connection success");
    } catch (SQLException | ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return conn;
  }
}
