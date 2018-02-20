package com.example.exceptionhandling;
import java.text.SimpleDateFormat;

public class PaymentBO {

    public boolean processPayment(com.example.exceptionhandling.Cheque cheque) throws InvalidDateException {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        String today="15/05/2017";
        //System.out.println("Cheque date is"+cheque.getChequeDate());
        //System.out.println("Today date is"+today);
        if (formatter.format(cheque.getChequeDate()).compareTo(today) < 0) {
            throw new InvalidDateException("Cheque is valid only for three months");
        }
        return true;
    }
}
