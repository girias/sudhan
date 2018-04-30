package com.java.example.JavaSBA_BuyersSpot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurchaseOrderBO {
    public Long createPurchaseOrder(List<Item> items, Integer[] quantity, String customerName, String mobileNumber, Date orderDate) {
        Double total = 0.0;
        Long poId = (long) 1;
        List<OrderLine> orderLine = new ArrayList<>();
        for (Item itm : items) {
            total = total + itm.getPrice();

        }
//        for (int i = 0; i < quantity; i++) {
//            int available = items.get(i).getAvailableQuantity();
//            if (quantity > available) {
//                throw new InsufficientQuantityException(("Item" + items.get(i).getName() + " is unavailable");
//            } else {
//                Long olId = UUID.randomUUID().getLeastSignificantBits();
//                PurchaseOrder purchaseOrder = new PurchaseOrder();
//                orderLine.add(new OrderLine(olId, items.get(i), purchaseOrder, items.get(i).getPrice(), quantity[i]));
//
//                Date createdDate = new Date();
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                purchaseOrder.setId(poId);
//                purchaseOrder.setOrderDate(orderDate);
//                purchaseOrder.setCreatedDate(orderDate);
//                purchaseOrder.setNumberOfItems(items.size());
//                purchaseOrder.setTotalAmount(total);
//                purchaseOrder.setCustomerName(customerName);
//                purchaseOrder.setMobileNumber(mobileNumber);
//                purchaseOrder.setOrderLineList(orderLine);
//            }
//        }
        return poId;
    }
}