package com.java.example.io;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLInvoiceParser {

    public static void main(String[] args) {
        try{

            File file = new File("com.java.example.Invoice.xml");

            JAXBContext jContext = JAXBContext.newInstance(Invoices.class);

            Unmarshaller unmarshallerObj = jContext.createUnmarshaller();

            System.out.println("unmarshallerObj: " + unmarshallerObj);
            Invoices invoice=(Invoices) unmarshallerObj.unmarshal(file);

            System.out.println("invoice: " + invoice);
            System.out.println(invoice.getPrice()+ " : " +invoice.getDate()+ " : " +invoice.getCustomer());

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
