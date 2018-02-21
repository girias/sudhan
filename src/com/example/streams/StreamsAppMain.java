package com.example.streams;

import java.io.File;

public class StreamsAppMain {
    public static void main(String[] args) {
        String inputFileName = "input.txt";
        File outputFile = new File("output.txt");

        InvoiceBO invoiceBO = new InvoiceBO();
        invoiceBO.findAllRejectedPayments(inputFileName, outputFile);
    }
}
