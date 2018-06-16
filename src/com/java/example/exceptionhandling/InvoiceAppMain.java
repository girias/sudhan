package com.java.example.exceptionhandling;

import java.util.Scanner;

public class InvoiceAppMain {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the invoice number :");
    String invoiceNumber = scanner.nextLine();

    System.out.println("Enter the total invoice amount :");
    String invoiceTotalAmount = scanner.nextLine();

    System.out.println("Enter the credit card number :");
    String creditCardNumber = scanner.nextLine();

    System.out.println("Enter the credit limit :");
    Double creditLimit = scanner.nextDouble();

    Invoice invoice = new Invoice(invoiceNumber, invoiceTotalAmount, 0);
    CreditCard creditCard = new CreditCard(creditCardNumber, creditLimit);

    System.out.println("Do you want to process invoice payment?(yes/no)");
    //        if(scanner.nextLine().equalsIgnoreCase("yes")) {
    //            System.out.println("Enter the amount :");
    //            Double amount = scanner.nextDouble();
    //            try {
    //                InvoiceBO.processPayment(invoice, creditCard, amount);
    //            } catch (CreditLimitExcption ex){
    //                System.out.println(ex);
    //            }
    //
    //        }
  }
}
