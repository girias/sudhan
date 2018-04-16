package com.java.example.encapsulation2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Sample Input and output
 * Enter the number of invoices :
 * 4
 * Enter the invoice 1 details :
 * Raj,Sri nagar,India,52670.00,Not Cleared,Ravi
 * Enter the invoice 2 details :
 * Emi,Kerala,India,52200.00,Not cleared,Shankar
 * Enter the invoice 3 details :
 * Julie,Mexico,USA,52000.69,Cleared,Williams
 * Enter the invoice 4 details :
 * Ram,Delhi,India,52312.20,Not cleared,Sasi
 * Customer details with status cleared Invoices :
 * Name            State           Country
 * Julie           Mexico          USA
 * Enter the com.java.example.Invoice creator name :
 * Viji
 * The total invoice value :
 * No invoice available
 */

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of invoices :");
        int n = Integer.parseInt(buf.readLine());
        // fill code here
        List<Invoice> inputData = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the invoice " + (i + 1) + " details :");
            String[] input = buf.readLine().split(",");
            Invoice invoice = new Invoice(new User(input[0], input[1], input[2]), Double.parseDouble(input[3]), input[4], input[5]);
            inputData.add(invoice);
        }

        Invoice[] invoiceArray = inputData.toArray(new Invoice[inputData.size()]);
        System.out.println("Customer details with status cleared Invoices :");
        System.out.format("%-15s %-15s %-15s", "Name", "State", "Country");
        InvoiceBO invoiceBO = new InvoiceBO();
        invoiceBO.displayUserDetailsByStatus("Cleared", invoiceArray);

        System.out.println("\nEnter the com.java.example.Invoice creator name :");
        String customerName = buf.readLine();
        System.out.println("The total invoice value :");
        Double sum = invoiceBO.getTotalInvoiceValue(customerName, invoiceArray);
        if (sum > 0.0) {
            System.out.print(new DecimalFormat("#0.00").format(sum));
        } else {
            System.out.println("No invoice available");
        }


    }

}


