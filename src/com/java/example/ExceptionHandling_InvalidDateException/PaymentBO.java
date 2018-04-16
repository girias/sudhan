package com.java.example.ExceptionHandling_InvalidDateException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PaymentBO {

    public boolean processPayment(Cheque cheque) throws InvalidDateException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date today = null;
        try {
            today = sdf.parse("15/05/2017");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int diffInDays = (int)((cheque.getChequeDate().getTime() - today.getTime())
                / (1000 * 60 * 60 * 24) );

        System.out.println(diffInDays);
        if(diffInDays > 90 || diffInDays < 0) {
            throw new InvalidDateException("Cheque is valid only for three months");
        }
        return true;
    }
}
