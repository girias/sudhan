package com.java.example.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException, SQLException {
    BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
    ItemDAO itemdao = new ItemDAO();

    List<Item> items = itemdao.getAllItems();
    System.out.format("%-15s %-15s %s\n", "Item ID", "Item Name", "Price");
    for (Item item : items) {
      System.out.format("%-15s %-15s %s\n", item.getId(), item.getName(), item.getPrice());
    }

    System.out.println("Enter the item id to update :");
    String itemId = buff.readLine();
    System.out.println("Enter the new price :");
    Double itemPrice = Double.parseDouble(buff.readLine());
    Item itemToUpdate = new Item(itemId, "", itemPrice);

    itemdao.updateItemPrice(itemToUpdate, itemPrice);

    System.out.println("Item details after update :");
    System.out.format("%-15s %-15s %s\n", "Item ID", "Item Name", "Price");

    List<Item> updatedItems = itemdao.getAllItems();
    for (Item item : updatedItems) {
      System.out.format("%-15s %-15s %s\n", item.getId(), item.getName(), item.getPrice());
    }
  }
}
