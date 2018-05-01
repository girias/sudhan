package com.java.example.JavaSBA_BuyersSpot;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PurchaseOrderBO {

    public Long createPurchaseOrder(List<Item> items, Integer[] quantity, String customerName, String mobileNumber, Date orderDate) throws InsufficientQuantityException {
        Double total = 0.0;
        Long poId = (long) 1;
        List<OrderLine> orderLine = new ArrayList<>();
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        PurchaseOrderDAO purchaseOrderDAO = new PurchaseOrderDAO();
        for (Item itm : items) {
            total = total + itm.getPrice();

        }
        for (int i = 0; i < items.size(); i++) {
            int available = items.get(i).getAvailableQuantity();
            if (available < quantity[i]) {
                throw new InsufficientQuantityException(("Item" + items.get(i).getName() + " is unavailable"));
            } else {
                Long olId = UUID.randomUUID().getLeastSignificantBits();

                orderLine.add(new OrderLine(olId, items.get(i), purchaseOrder, items.get(i).getPrice(), quantity[i]));

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
                purchaseOrderDAO.createPurchaseOrder(purchaseOrder);
            }
        }
        return poId;
    }
}