package com.example.exceptionhandling;

import java.util.Date;

public class PaymentBO {

    public boolean processPayment(Cheque cheque) throws InvalidDateException {

        int diffInDays = (int)( (new Date().getTime() - cheque.getChequeDate().getTime())
                / (1000 * 60 * 60 * 24) );

        if(Math.abs(diffInDays) > 30) {
            throw new InvalidDateException("Cheque is valid only for three months");
        }
        return true;
    }
}
