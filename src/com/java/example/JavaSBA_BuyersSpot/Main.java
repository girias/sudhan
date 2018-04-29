package com.java.example.JavaSBA_BuyersSpot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String args[]) throws IOException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ItemDAO iDAO = new IItemDAO();
        List<Item> items = iDAO.getAllItems();
        Iterator<Item> itr = items.iterator();

        System.out.format("%15s %-25s %-25s %-15s\n", "Item ID", "Name", "Available Quantity", "price");
        while (itr.hasNext()) {
            Item item = itr.next();
            System.out.format("%15s %-25s %-25s %-15s\n", item.getId(), item.getName(), item.getAvailableQuanityt(), item.getPrice());
        }
        System.out.println("Creating new purchase order...");
        System.out.println("Enter Customer Name");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String customerName = reader.readLine();
        System.out.println("Enter Contact Number");
        String mobile = reader.readLine();
        System.out.println("Enter Order Date (yyyy-MM-dd):");
        Date orderDate = sdf.parse(reader.readLine());
        System.out.println("Enter all the Item ID you want to purchase:");
        String[] ids = reader.readLine().split(",");
        List<item> itm = new ArrayList<item>();
        for (int i = 0; i < ids.length; i++) {
            item it = iDAO.getItemById(Integre.valueof(ids[i]));
            itm.add(it);

        }
        System.out.println("Enter number of quantities:");
        String[] quantities = reader.readLine().split(",");
        Integer[] quantity = new Integer[quantities.length];
        for (int i = 0; i < quantities; i++) {
            quantity[i] = Integer.parseInt(quantities[i]);

        }
        PurchaseorderBO purchaseBo = new PurchaseorderBO();
        Long id = purchaseBo.createPurchaseOrder(itm, quantity, customerName, mobile, orderDate);
        System.out.println("Order placed with id" + id);

    }
}
