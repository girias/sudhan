package com.example.exceptionhandling;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PaymentBO {

    public boolean processPayment(Cheque cheque) throws InvalidDateException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String chequeDate = sdf.format(cheque.getChequeDate());

        String today = sdf.format(new Date());
        int diffInDays = (int)( (new Date().getTime() - cheque.getChequeDate().getTime())
                / (1000 * 60 * 60 * 24) );

        if(Math.abs(diffInDays) > 30) {
            throw new InvalidDateException("Cheque is valid only for three months");
        }
        return true;
    }
}
