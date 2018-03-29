package com.example.Collections;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            System.out.println("Enter the number of shipment :");
            int numberOfShipment = sc.nextInt();
            int numberOfShipments[] = new int[11];
            List<Shipment> obj = new ArrayList<Shipment>();
            System.out.println("Enter the shipment details :");
            for (int i = 0; i < numberOfShipment; i++) {
                String[] parts = sc.next().split(",");
                obj.add(new Shipment(Integer.parseInt(parts[0]), parts[1], df.parse(parts[2]), df.parse(parts[3])));
            }
            System.out.println("No of days    No of shipments");
            for (int i = 0; i < obj.size(); i++) {
                Date d1 = obj.get(i).getDispatchedDate();
                Date d2 = obj.get(i).getReceivedDate();
                long difference = d2.getTime() - d1.getTime();
                int daysBetween = (int) (difference / (1000 * 60 * 60 * 24));
                numberOfShipments[daysBetween] += 1;
            }
            for (int i = 0; i < numberOfShipments.length; i++) {
                System.out.println(i + "  " + numberOfShipments[i]);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
