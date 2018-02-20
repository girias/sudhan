package com.example.exceptionhandling;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PaymentBO {

    public boolean processPayment(com.example.exceptionhandling.Cheque cheque) throws InvalidDateException {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String chequeDate = formatter.format(cheque.getChequeDate());

        String today="15/05/2017";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = formatter.parse(today);
        System.out.println("Today date is"+date1)
        //String today = formatter.format(new Date());
        if(cheque.getChequeDate().getTime() < new Date().getTime()) {
            throw new InvalidDateException("Cheque is valid only for three months");
        }
        return true;
    }
}
