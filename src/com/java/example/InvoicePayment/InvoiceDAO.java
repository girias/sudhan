package com.java.example.InvoicePayment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAO {


    public List<Invoice> getAllInvoices() {
        List<Invoice> inv = new ArrayList<Invoice>();
        try {
            Connection dbconn = DbConnection.getConnection();
            Statement stmt = dbconn.createStatement();
            String sql = "Select id, customer_name, payment_attempts,total_amount, balance, status from Invoice order by id asc:";

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                inv.add(new Invoice(rs.getInt("Id"), rs.getString("customer_name"), rs.getInt("payment_attempts"), rs.getDouble("total_amount"), rs.getDouble("balance"), rs.getString("status")));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inv;
    }

    public void updateInvoiceDetails(Integer invoiceId, Double amount) {
        try {
            Connection dbconn = DbConnection.getConnection();
            Statement stmt = dbconn.createStatement();
            String sql1 = "Select payment_attempts, balance from Invoice where id = '" + invoiceId + "':";

            ResultSet rs = stmt.executeQuery(sql1);

            Integer count = 0;
            Double balance = 0.0;
            while (rs.next()) {
                count = rs.getInt("payment_attempts");
                balance = rs.getDouble("balance");

            }
            count++;
            balance = balance - amount;
            String sql2 = "update Invoice set balance='" + balance + "' where id = '" + invoiceId + "'";
            String sql3 = "update Invoice set payment_attempts='" + count + "' where id = '" + invoiceId + "'";

            stmt.executeQuery(sql2);
            stmt.executeQuery(sql3);

            System.out.println("The balance amount is " + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
