package com.example.encapsulation;

import java.text.SimpleDateFormat;
import java.util.Scanner;


public class Main {

    public static void main(String[] Args) throws  Exception{
        Scanner sc = new Scanner(System.in);
        Item item[] = new Item[9];

        item[0]= new Item(111,"Laptop",28000.0);
        item[1]= new Item(112,"Headset",900.0);
        item[2]= new Item(113,"Watch",3000.0);
        item[3]= new Item(114,"Fan",5000.0);
        item[4]= new Item(211,"Keyboard",4000.0);
        item[5]= new Item(212,"Mouse",300.0);
        item[6]= new Item(311,"Mike",2000.0);
        item[7]= new Item(312,"PC",25000.0);
        item[8]= new Item(314,"Inverter",11000.0);
        for(int i = 0;i<item.length;i++){
            System.out.println(item[i].toString());
        }
        System.out.println("Enter invoice details");
        String input[] = sc.next().split(",");
        SimpleDateFormat formatter = new SimpleDateFormat("d-M-yyyy");
        Invoice details = new Invoice(Integer.parseInt(input[0]),input[1],input[2],formatter.parse(input[3]),formatter.parse(input[4]));
        System.out.println("Enter number of invoice line");
        int invoiceCount= sc.nextInt();
        InvoiceLine invoiceLine[] = new InvoiceLine[invoiceCount];
        Double finalAmount = 0.0;
        for(int i=0;i<invoiceCount;i++) {
            System.out.println("Enter the invoice line " + Integer.toString(i + 1) + " details");
            String newLine[] = sc.next().split(",");
            InvoiceBO invoiceBO = new InvoiceBO();
            Item temp = invoiceBO.findItemById(Integer.parseInt(newLine[0]), item);
            invoiceLine[i] = new InvoiceLine(temp, Integer.parseInt(newLine[1]), temp.getPrice());
        }
        details.setInvoiceLine(invoiceLine);
        invoiceLine = details.getInvoiceLine();
        //System.out.println("Invoice Id      Item Name        Quantity        Price           Total Amount");
        System.out.format("%-15s %-15s  %-15s %-15s %-15s\n","Invoice Id","Item Name","Quantity","Price","Total Amount");
        for(int i=0;i<details.getInvoiceLine().length;i++){
            System.out.println(details.getId()+"      "+invoiceLine[i].getItem().getName()+"      "+invoiceLine[i].getQuantity()+"      "+invoiceLine[i].getItem().getPrice()+"      "+invoiceLine[i].getAmount()+"      ");
        }
        finalAmount += InvoiceBO.totalInvoiceAmount(details);
        System.out.println("Total Amount   "+finalAmount);
        InvoiceBO.nextTwoRemainders(details);
    }
}

