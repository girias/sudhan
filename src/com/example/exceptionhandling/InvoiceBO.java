package com.example.exceptionhandling;

public class InvoiceBO {

    public static void  processPayment(Invoice invoice,CreditCard creditcard,Double amount) throws CreditLimitExcption{



        System.out.println("Do you want to process invoice payment?(yes/no)");


        System.out.println("Payment Successfully done in 2 attempts");

    }
}
