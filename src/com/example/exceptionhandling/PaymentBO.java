package com.example.exceptionhandling;
import java.util.Date;

public class PaymentBO {

    public boolean processPayment(com.example.exceptionhandling.Cheque cheque) throws InvalidDateException {

        if(cheque.getChequeDate().getTime() < new Date().getTime()) {
            throw new InvalidDateException("Cheque is valid only for three months");
        }
        return true;
    }


}
