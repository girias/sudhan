package com.example.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] Args) throws IOException {
        //Scanner sc = new Scanner(System.in);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Item> itemList = new ArrayList<Item>();

        itemList.add(new Item(1200L, "Moto G5 Plus", "Paypal Digital Gifts", 15000.0, 3.5));
        itemList.add(new Item(1201L, "Moto M", "deluxe-marken", 15500.0, 4.5));
        itemList.add(new Item(1202L, "Lenovo P2", "Paypal Digital Gifts", 22000.0, 4.0));
        itemList.add(new Item(1203L, "Lenovo Vibe K5 Note", "gohastings", 25000.0, 3.5));
        itemList.add(new Item(1204L, "Asus Zenfone 3", "deluxe-marken", 18000.0, 3.0));
        itemList.add(new Item(1205L, "Lenovo Vibe K5 Note", "kayfast1", 23500.0, 3.2));
        itemList.add(new Item(1209L, "Samsung Galaxy On5", "deluxe-marken", 16000.0, 3.0));
        itemList.add(new Item(1206L, "Moto G5 Plus", "deluxe-marken", 16500.0, 3.8));
        itemList.add(new Item(1207L, "Asus Zenfone 3", "Paypal Digital Gifts", 18500.0, 4.6));
        itemList.add(new Item(1208L, "Lenovo Vibe K5 Note", "Paypal Digital Gifts", 24000.0, 4.1));
        itemList.add(new Item(1210L, "Asus Zenfone 3", "deluxe-marken", 17500.0, 3.2));
        itemList.add(new Item(1211L, "Lenovo P2", "kayfast1", 25000.0, 3.4));
        itemList.add(new Item(1212L, "Moto M", "kayfast1", 15000.0, 3.0));
        itemList.add(new Item(1213L, "Asus Zenfone 3", "kayfast1", 18000.0, 3.5));
        itemList.add(new Item(1214L, "Moto G5 Plus", "deluxe-marken", 14000.0, 3.0));

        List<String> toDisplay = new ArrayList<>(Arrays.asList("Moto G5 Plus", "Moto M", "Lenovo P2", "Lenovo Vibe K5 Note", "Asus Zenfone", "Lenovo Vibe K5 Note", "Samsung Galaxy On5"));

        try {
            for (int i = 0; i < toDisplay.size(); i++) {
                System.out.println(i + 1 + " " + toDisplay.get(i));
            }
            System.out.println("Enter all the items you want to purchase:");

            String[] items = reader.readLine().split(",");
            SearchProviderThread ob[] = new SearchProviderThread[items.length];
            for (int i = 0; i < items.length; i++) {
                String name = itemList.get(Integer.parseInt(items[i]) - 1).getName();
                System.out.println(">>>>>" + name);
                ob[i] = new SearchProviderThread(name, name, itemList);
                Thread.sleep(1000);
                ob[i].start();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
