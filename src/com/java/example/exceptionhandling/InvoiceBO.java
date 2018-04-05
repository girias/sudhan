package com.java.example.exceptionhandling;

public class InvoiceBO {

    public static void processPayment(Invoice invoice, CreditCard creditcard, Double amount) {



        System.out.println("Do you want to process invoice payment?(yes/no)");


        System.out.println("Payment Successfully done in 2 attempts");

    }
}
