package com.java.example.JavaSBA_InvoiceProcess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAO {

    public Integer invoiceCreation(Invoice invoiceObj) {
        Integer inv = 0;
        try {
            Connection dbconn = DbConnection.getConnection();
            Statement stmt = dbconn.createStatement();

            //////////// Incomplete Insert Query /////////////////
            String sql1 = "INSERT INTO invoice (invoice_number, status, amount, created_date, user_id) values (";

            stmt.executeQuery(sql1);
            String sql2 = "Select id from invoice where invoice_number = '" + invoiceObj.getInvoiceNumber() + "':";
            ResultSet rs = stmt.executeQuery(sql2);

            while (rs.next()) {
                inv = rs.getInt("id");
            }

        } catch (Exception e) {
        }
        return inv;
    }


    public List<Invoice> getAllInvoiceList() {
        List<String> invoices = new ArrayList<>();
        try {
            Connection dbconn = DbConnection.getConnection();
            Statement stmt = dbconn.createStatement();
            String sql1 = "Select id, invoice_number, status, amount, created_date, user_id from invoice:";
            ResultSet rs1 = stmt.executeQuery(sql1);

            while (rs1.next()) {
                ////////////// Verify all the below queries ///////////

                String sql2 = "Select id, username, password, address, role from user where id='" + rs1.getInt("user_id") + "':";
                ResultSet rs2 = stmt.executeQuery(sql2);
                User u = null;
                while (rs2.next()) {
                    u = new User(rs2.getInt("id"), rs2.getString("username"), rs2.getString("password"), rs2.getString("address"), rs2.getString("role"));

                }
                Invoice inv = new Invoice(rs1.getInt("id"), rs1.getString("invoice_number"), rs1.getString("Status"), rs1.getString("amount"), rs1.getDate("created_date"), rs1.get("user_id"));
                invoices.add(inv);
            }

        } catch (Exception e) {
        }
        return invoices;


    }

    public void updateInvoiceStatus(Invoice invoiceObj, String status) {
        try {
            Connection dbconn = DbConnection.getConnection();
            Statement stmt = dbconn.createStatement();
            String sql = "Update invoice set status ='" + status + "' where id = '" + invoiceObj.getId() + "':";
            stmt.executeQuery(sql);
        } catch (Exception e) {
        }

    }

    public void invoicePayment(Invoice invoiceObj) {
        try {
            Connection dbconn = DbConnection.getConnection();
            Statement stmt = dbconn.createStatement();
            String sql = "Update invoice set status ='Paid' where id = '" + invoiceObj.getId() + "':";
            stmt.executeQuery(sql);
        } catch (Exception e) {
        }

    }
}

