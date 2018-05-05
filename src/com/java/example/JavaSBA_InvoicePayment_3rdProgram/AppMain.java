package com.java.example.JavaSBA_InvoicePayment_3rdProgram;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AppMain {


    public static void main(String[] args) throws Exception {

        //fill the code
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Invoice Details:");
        System.out.format("%-5s %-15s %-20s %-15s %-10s %s\n", "ID", "Customer Name", "Payment Attempts", "Total Amount", "Balance", "Status");

        //fill the code
        List<Invoice> invoices = new ArrayList<Invoice>();
        InvoiceDAO invoiceDAO = new InvoiceDAO();
        Invoice inv = null;
        invoices = invoiceDAO.getAllInvoices();
        Iterator<Invoice> itr = invoices.iterator();
        while (itr.hasNext()) {
            inv = itr.next();
            System.out.format("%-5s %-15s %-20s %-15s %-10s %s\n", inv.getId(), inv.getCustomerName(), inv.getPaymentAttempts(), inv.getTotalAmount(), inv.getBalance(), inv.getStatus());
        }

        System.out.println("Enter the invoice id to pay :");
        Integer id = Integer.parseInt(buff.readLine());
        System.out.println("Enter the Payment mode:\n1. Credit Card\n2. Cheque\nEnter your choice :");
        Integer choice = Integer.parseInt(buff.readLine());

        Payment pay;
        double balance, amountPaid;

        if (choice == 1) {

            System.out.println("Enter the name :");
            String name = buff.readLine();

            System.out.println("Enter the amount :");
            Double amount = Double.parseDouble(buff.readLine());

            System.out.println("Enter the card number :");
            String cardNo = buff.readLine();

            System.out.println("Enter the cvv :");
            String cvv = (buff.readLine());

            System.out.println("Enter the card name :");
            String cardName = buff.readLine();

            //fill the code
            //String accountHolderName, double amount, String cardNumber, String cvv, String cardName
//			CreditCardPayment ccPayment = new CreditCardPayment(name, amount, cardNo, cvv, cardName);
            try {
                pay = new CreditCardPayment(name, amount, cardNo, cvv, cardName);
                amountPaid = pay.calculateTotalAmount();
                itr = invoices.iterator();
                while (itr.hasNext()) {
                    inv = itr.next();
                    if (inv.getId() == id) {
                        break;
                    }
                }
                balance = inv.getBalance() - amount;
//				System.out.println(inv.getTotalAmount() + "|" + amount + "|" + balance);
                invoiceDAO.updateInvoiceDetails(id, balance);
                System.out.println("Total Amount to be paid is " + amountPaid);
                System.out.println("The balance amount is " + balance);
            } catch (InvalidPaymentException ex) {
                System.out.println("InvalidPaymentException: " + ex.getMessage());
            }

        } else if (choice == 2) {

            System.out.println("Enter the name :");
            String name = buff.readLine();

            System.out.println("Enter the amount :");
            Double amount = Double.parseDouble(buff.readLine());

            System.out.println("Enter the bank name :");
            String bankName = buff.readLine();

            System.out.println("Enter the cheque number :");
            String cNo = buff.readLine();

            System.out.println("Enter the cheque date :");
            Date date = sdf.parse(buff.readLine());

            //fill the code
            // String accountHolderName, double amount, String bankName, String checkNumber, Date checkDate
//			ChequePayment cPayment = new ChequePayment(name, amount, bankName, cNo, date);
            try {
                pay = new ChequePayment(name, amount, bankName, cNo, date);
                amountPaid = pay.calculateTotalAmount();
                itr = invoices.iterator();
                while (itr.hasNext()) {
                    inv = itr.next();
                    if (inv.getId() == id) {
                        break;
                    }
                }
                balance = inv.getBalance() - amount;
                invoiceDAO.updateInvoiceDetails(id, balance);
                System.out.println("Total Amount to be paid is " + amountPaid);
                System.out.println("The balance amount is " + balance);
            } catch (InvalidPaymentException ex) {
                System.out.println("InvalidPaymentException: " + ex.getMessage());
            }
        } else {

            //fill the code
            System.out.println("Invalid Input");

        }
    }


}
