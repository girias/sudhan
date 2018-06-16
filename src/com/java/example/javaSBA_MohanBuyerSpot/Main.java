package com.java.example.javaSBA_MohanBuyerSpot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

  public static void main(String args[]) throws IOException, ParseException {

    // fill the code

    ItemDAO idao = new ItemDAO();

    List<Item> itemList = idao.getAllItems();

    System.out.format(
        "%-15s %-25s %-25s %-15s\n", "Item ID", "Name", "Available Quantity", "Price");

    for (Item item : itemList) {

      System.out.format(
          "%-15s %-25s %-25s %-15s\n",
          item.getId(), item.getName(), item.getAvailableQuantity(), item.getPrice());
    }

    System.out.println("Creating new purchase order...");

    System.out.println("Enter Customer Name:");

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String customerName = reader.readLine();

    System.out.println("Enter Contact Number:");

    String mobile = reader.readLine();

    System.out.println("Enter Order Date(yyyy-MM-dd):");

    String pattern = "yyyy-MM-dd";

    SimpleDateFormat sdf = new SimpleDateFormat(pattern);

    Date orderDate = sdf.parse(reader.readLine());

    System.out.println("Enter all the Item ID you want to purchase:");

    String strItemList = reader.readLine();

    String[] strTok = strItemList.split(",");

    List<Item> orderItemList = new ArrayList<Item>();

    for (String str : strTok) {

      orderItemList.add(idao.getItemById(Long.parseLong(str)));
    }

    System.out.println("Enter number of quantities:");

    String strItemQty = reader.readLine();

    strTok = strItemQty.split(",");

    // fill the code

    int[] itemQtyList = new int[strTok.length];

    int n = 0;

    for (String str : strTok) {

      itemQtyList[n++] = Integer.parseInt(str);
    }

    PurchaseOrderBO bo = new PurchaseOrderBO();

    try {

      long orderId =
          bo.createPurchaseOrder(orderItemList, itemQtyList, customerName, mobile, orderDate);

      System.out.println("Order placed with id " + orderId);

    } catch (InsuffcientQuantityException e) {

      System.out.println(e.getMessage());
    }
  }
}
