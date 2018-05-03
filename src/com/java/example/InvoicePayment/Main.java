package com.java.example.InvoicePayment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("invoice Details:");
        System.out.format("%-5s %-15s %-20s %-15s %-10s %s\n", "Customer Name", "Payment Attempts", "Total Amount", "Balance", "Status");

        //fill the code

        List<Invoice> inv = new ArrayList<Invoice>();
        InvoiceDAO invDao = new InvoiceDAO(), invDao2 = new InvoiceDAO();
        inv = invDao.getAllInvoices();
        for (Invoice i : inv) {
            System.out.format("%-5s %-15s %-20s %-15s %-10s %s\n", i.getId(), i.getCustomerName(), i.getPaymentAttempts(), i.getTotalAmount(), i.getBalance(), i.getStatus());

        }
        payment ccp = null;

        ChequePayment cp = null;
        System.out.println("Enter the invoice id to pay :");
        Integer id = Integer.parseInt(buff.readLine());
        System.out.println("Enter the Payment mode:\n1. Credit Card\n2. Cheque\nEnter your choice :");
        Integer choice = Integer.parseInt(buff.readLine());

        if (choice == 1) {
            System.out.println("Enter the name :");
            String name = buff.readLine();

            System.out.println("Enter the amount :");
            Double amount = Double.parseDouble(buff.readLine());

            System.out.println("Enter the card number :");
            String cardNo = buff.readLine();

            System.out.println("Enter the cvv :");
            String cvv = buff.readLine();

            System.out.println("Enter the card name :");
            String cardName = buff.readLine();

            ccp = new CreditCardPayment(cardNo, cvv, cardName);
            ccp.setAmount(amount);
            ccp.setAccountHolderName(name);
            Double total;
            total = ccp.calculateAount();
            System.out.println("Total Amount to be paid is " + total);
            invDao2.updateInvoiceDetails(id, amount);
        } else if (choice == 2) {
            System.out.println("Enter the name :");
            String name = buff.readLine();

            System.out.println("Enter the amount :");
            Double amount = Double.parseDouble(buff.readLine());

            System.out.println("Enter the bank name :”); "
                    String bankName = buff.readLine();

            System.out.println();
            n("Enter the cheque number :");
            String cNo = buff.readLine();

            System.out.println("Enter the cheque date :”);
                    Date date = sdf.parse(buff.readLine());

            //fill the code
            cp = new ChequePayment(bankName, cNo, date);
            cp.setÄmount(amount);
            Cp.setAccountHolderName(name);
            invDa02.updateInvoiceDetai1s(id, amount);
        } else {
            System.out.println(“Invalid Input “);

        }
    }
}

