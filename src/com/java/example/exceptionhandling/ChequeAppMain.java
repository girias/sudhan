package com.java.example.exceptionhandling;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ChequeAppMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the cheque details");
        System.out.println("Enter the bank name :");
        String bankName = scanner.nextLine();

        System.out.println("Enter the cheque number :");
        String chequeNumber = scanner.nextLine();

        System.out.println("Enter the cheque date :");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date chequeDate = new Date();
        try {
            chequeDate = formatter.parse(scanner.nextLine());
        } catch (ParseException e) {

            e.printStackTrace();
        }

        Cheque cheque = new Cheque(bankName,chequeNumber,chequeDate);
        PaymentBO paymentBO = new PaymentBO();

        try {
            if (paymentBO.processPayment(cheque)) {
                System.out.println("Cheque is sent to clearing house");
            }
        } catch (InvalidDateException e) {
            System.out.println(e);
        }
    }
}
