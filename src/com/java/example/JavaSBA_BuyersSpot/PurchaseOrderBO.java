package com.java.example.JavaSBA_BuyersSpot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurchaseOrderBO {

    public Long createPurchaseOrder(List<Item> items, Integer[] quantity, String customerName, String mobileNumber, Date orderDate) throws InsufficientQuantityException {
        Double total = 0.0;
        Long poId = 0l;
        List<OrderLine> orderLine = new ArrayList<>();

        PurchaseOrderDAO purchaseOrderDAO = new PurchaseOrderDAO();
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        for (Item itm : items) {
            total = total + itm.getPrice();

        }
        for (int i = 0; i < items.size(); i++) {
            int available = items.get(i).getAvailableQuantity();
            if (available < quantity[i]) {
                throw new InsufficientQuantityException(("Item" + items.get(i).getName() + " is unavailable"));
            } else {

                orderLine.add(new OrderLine(0l, items.get(i), purchaseOrder, items.get(i).getPrice(), quantity[i]));

//                purchaseOrder.setId(poId);
                purchaseOrder.setOrderDate(orderDate);
                purchaseOrder.setCreatedDate(new Date());
                purchaseOrder.setNumberOfItems(items.size());
                purchaseOrder.setTotalAmount(total);
                purchaseOrder.setCustomerName(customerName);
                purchaseOrder.setMobileNumber(mobileNumber);
                purchaseOrder.setOrderLineList(orderLine);
                poId = purchaseOrderDAO.createPurchaseOrder(purchaseOrder);
            }
        }
        return poId;
    }
}