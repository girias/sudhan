package com.java.example.JavaSBA_InvoicePayment_3rdProgram;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAO {

    public InvoiceDAO() {
        // TODO Auto-generated constructor stub
    }

    public List<Invoice> getAllInvoices() {
        List<Invoice> invoices = new ArrayList<Invoice>();
        try {
            Connection conn = DbConnection.getConnection();
            Statement stmt = conn.createStatement();
            String sql = " select * from invoice";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //(int id, String customerName, int paymentAttempts, double totalAmount, double balance, String status)
                Invoice inv = new Invoice(rs.getInt("id"), rs.getString("customer_name"), rs.getInt("payment_attempts"), rs.getDouble("total_amount"), rs.getDouble("balance"), rs.getString("status"));
                invoices.add(inv);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return invoices;
    }

    public void updateInvoiceDetails(int invoiceId, double balanceAmount) {
        try {
            Connection conn = DbConnection.getConnection();
            Statement stmt = conn.createStatement();
            Invoice inv = null;
            String sql = " select * from invoice where id=" + invoiceId;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //(int id, String customerName, int paymentAttempts, double totalAmount, double balance, String status)
                inv = new Invoice(rs.getInt("id"), rs.getString("customer_name"), rs.getInt("payment_attempts"), rs.getDouble("total_amount"), rs.getDouble("balance"), rs.getString("status"));
            }

            sql = "update invoice set balance=" + balanceAmount + ", payment_attempts=" + (inv.getPaymentAttempts() + 1) + " where id=" + invoiceId;
            stmt.executeUpdate(sql);
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

}
