package com.java.example.JavaSBA_BuyersSpot;

import java.text.SimpleDateFormat;
import java.util.UUID;

public class PurchaseOrderBO {
    public Long createPurchaseOrder(Lis<Item> items, Integer[] quantity, String customerName, String mobileNumber, Date orderDate) {
        Double total = 0.0;
        Long poId = (long) 1;
        List<OrderLine> orderLine = new ArrayList<OrderLine>();
        for (Item itm : items) {
            total = total + itm.getPrice();

        }
        for (int i = 0; i < quantity; i++) {
            int available = items.get(i).getAvailableQuantity();
            if (quantity[i] > available) {
                throw new InsufficientQuantityException(("Item" + items.get(i).getName() + " is unavailable");
            } else {
                Long olid = UUID.randomUUID().getLeastSignificantBits();
                PurchaseOrder purchaseOrder = new PurchaseOrder();
                orderLine.add(new OrderLine(olId, items.get(i), purchaseorder, items.get(i).getPrice(), quantity[i]));

                Date createdDate = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                purchaseOrder.setId(poId);
                purchaseOrder.setOrderDate(orderDate);
                purchaseOrder.setCreatedDate(orderDate);
                purchaseOrder.setNumberOfItems(items.size());
                purchaseOrder.setTotalAmount(total);
                purchaseOrder.setCustomerName(customerName);
                purchaseOrder.setMobileNumber(mobileNumber);
                purchaseOrder.setOrderLineList(orderLine);
            }
        }
        return poId;
    }
}