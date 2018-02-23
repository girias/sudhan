package com.example.Encapsulation;

import java.text.SimpleDateFormat;
import java.util.*;

public class InvoiceBO {


    public static String addDays(SimpleDateFormat df, Date date){
        int  numberOfdays = 16;
        Calendar c = GregorianCalendar.getInstance();
        c.setTime(date);
        c.add(GregorianCalendar.DAY_OF_MONTH, numberOfdays);
        numberOfdays -=2;
        return df.format( c.getTime() ) ;
    }
    Item findItemById(int itemId,Item item[]){
        for(int i=0;i<item.length;i++){
            if(itemId == item[i].getId()){
                return item[i];
            }
        }
        return null;

    }
    static Double totalInvoiceAmount(Invoice invoice) {
        InvoiceLine totalInvoice[] = invoice.getInvoiceLine();
        Double totalAmount = 0.0;
        for (int i = 0; i < totalInvoice.length; i++) {
//            System.out.println(totalInvoice[i].getAmount());
            totalAmount+= totalInvoice[i].getAmount() * totalInvoice[i].getQuantity();
        }
        return  totalAmount;
    }


    static void nextTwoRemainders(Invoice invoice) throws Exception{
        SimpleDateFormat formatter = new SimpleDateFormat("d-M-yyyy");
        String dueDate = addDays(formatter,invoice.getStartDate());
        System.out.println("Due Date Remainder 1 : "+dueDate);
        System.out.println("Due Date Remainder 2 : "+addDays(formatter,formatter.parse(dueDate)));
    }

}
