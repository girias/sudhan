package com.example.exceptionhandling;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the cheque details");
        System.out.println("Enter the bank name :");
        String bankName = scanner.nextLine();

        System.out.println("Enter the cheque number :");
        String chequeNumber = scanner.nextLine();

        System.out.println("Enter the cheque date :");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date chequeDate = new Date("05/15/2017");
        try {
            chequeDate = simpleDateFormat.parse(scanner.nextLine());
        } catch (ParseException e) {

            e.printStackTrace();
        }

        com.example.exceptionhandling.Cheque cheque = new com.example.exceptionhandling.Cheque(bankName,chequeNumber,chequeDate);
        com.example.exceptionhandling.PaymentBO paymentBO = new com.example.exceptionhandling.PaymentBO();

        try {
            if (paymentBO.processPayment(cheque)) {
                System.out.println("Cheque is sent to clearing house");
            }
        } catch (com.example.exceptionhandling.InvalidDateException e) {
            System.out.println(e);
        }
    }
}
