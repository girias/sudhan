package com.java.example.javaSBA_MohanBuyerSpot;

import java.util.Date;
import java.util.List;

public class PurchaseOrderBO {

    public long createPurchaseOrder(List<Item> items, int[] quantity, String customerName, String mobileNumber, Date orderDate) throws InsuffcientQuantityException

    {

        for (int n = 0; n < items.size(); n++)

        {

            if (items.get(n).getAvailableQuantity() < quantity[n])

                throw new InsuffcientQuantityException("Item " + items.get(n).getName() + " is unavailable");

//OrderLine oln= new OrderLine(n, items.get(n), items.get(n).getPrice()*quantity[n], quantity[n]);

        }

        return 1;

    }

}
