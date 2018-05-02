package com.java.example.JavaSBA_InvoiceProcess;

import java.sql.ResultSet;

public class InvoiceDAO {

    public Integer invoiceCreation(Invoice invoiceObj) {
        Integer inv = null;
        try {
            Connection dbconn = DbConnection.getConnection();
            statement stmt = dbconn.createStatement();


            // Need to be rewrite the query...//////
            String sql1 = "INSERT INTO invoice (invoice number, status, amount, created_date , user_id) values(";

            stmt.executeUpdate(sql1);
            String sql2 = "Select id from invoice where invoice_number = '" + invoiceObj.getInvoiceNumber() + "':";
            ResultSet rs = stmt.executeQuery(sql2);
            while (rs.next()) {
                inv = rs.getInt("id");

            }
        } catch (Exception e) {
        }
        return inv;

    }

}

