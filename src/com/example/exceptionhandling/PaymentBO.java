package com.example.exceptionhandling;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PaymentBO {

    public boolean processPayment(com.example.exceptionhandling.Cheque cheque) throws InvalidDateException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String chequeDate = sdf.format(cheque.getChequeDate());

        String today = sdf.format(new Date());
        if(chequeDate.compareTo(today) < 0) {
            throw new InvalidDateException("Cheque is valid only for three months");
        }
        return true;
    }
}
