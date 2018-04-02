package com.java.example.threads;

import java.util.ArrayList;
import java.util.List;


public class SearchProviderThread implements Runnable {
    List<Item> itemList = new ArrayList<Item>();
    String itemName;
    List<Item> filteredItems = new ArrayList<Item>();
    private Thread t;
    private String threadName;

    SearchProviderThread(String threadName) {
        this.threadName = threadName;
    }

    public SearchProviderThread(String threadName, String itemName, List<Item> itemList) {
        this.threadName = threadName;
        this.itemName = itemName;
        this.itemList = itemList;
    }
    /*class myCompare implements Comparator<Item>{
        @Override
        @SuppressWarnings("deprecation")
        public int compare(Item i1,Item i2){
            return (i1.getPrice() > i2.getPrice())? 1: -1;
        }
    }*/

    public void run() {
        try {

            for (Item item : itemList) {
                if (item.getName().equals(this.itemName)) {
                    this.filteredItems.add(item);
                }
            }
            //Collections.sort(this.filteredItems, new myCompare());
            System.out.println(threadName);
            for (Item f : this.filteredItems) {
                System.out.println(f.getItemId() + " " + f.getProvider() + " " + f.getPrice() + " " + f.getRating());
            }


        } catch (Exception e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Item> getFilteredItems() {
        return filteredItems;
    }

    public void setFilteredItems(List<Item> filteredItems) {
        this.filteredItems = filteredItems;
    }
}