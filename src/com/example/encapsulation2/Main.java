package com.example.encapsulation2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of invoices :");
        int n = Integer.parseInt(buf.readLine());
        // fill code here
        List<Invoice> inputData = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the invoice" + n + 1 + "details :");
            String[] input = buf.readLine().split(",");
            Invoice invoice = new Invoice(new User(input[0], input[1], input[2]), Double.parseDouble(input[3]), input[4], input[5]);
            inputData.add(invoice);
        }

        Invoice[] invoiceArray = inputData.toArray(new Invoice[inputData.size()]);
        System.out.println("Customer details with status cleared Invoices :");
        InvoiceBO invoiceBO = new InvoiceBO();
        invoiceBO.displayUserDetailsByStatus("Cleared", invoiceArray);

        System.out.println("\nEnter the Invoice creator name :");
        String customerName = buf.readLine();
        System.out.println("The total invoice value :");
        System.out.println(invoiceBO.getTotalInvoiceValue(customerName, invoiceArray));


    }

}


