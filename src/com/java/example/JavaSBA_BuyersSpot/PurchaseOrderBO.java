package com.java.example.JavaSBA_BuyersSpot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurchaseOrderBO {

  public Long createPurchaseOrder(
      List<Item> items,
      Integer[] quantity,
      String customerName,
      String mobileNumber,
      Date orderDate)
      throws InsufficientQuantityException {
    PurchaseOrderDAO purchaseOrderDAO = new PurchaseOrderDAO();
    PurchaseOrder purchaseOrder = new PurchaseOrder();
    purchaseOrder.setCustomerName(customerName);
    purchaseOrder.setMobileNumber(mobileNumber);
    purchaseOrder.setOrderDate(orderDate);
    purchaseOrder.setCreatedDate(new Date());
    List<OrderLine> orderLine = new ArrayList<>();
    Double total = new Double(0);
    for (int i = 0; i < items.size(); i++) {
      Item item = items.get(i);
      int available = item.getAvailableQuantity();
      if (available < quantity[i]) {
        throw new InsufficientQuantityException(("Item " + item.getName() + " is unavailable"));
      }
      OrderLine line = new OrderLine();
      line.setItem(item);
      line.setPrice(item.getPrice());
      line.setPurchaseOrder(purchaseOrder);
      line.setQuantity(quantity[i]);
      orderLine.add(line);
      total = total + item.getPrice();
    }
    purchaseOrder.setOrderLineList(orderLine);
    purchaseOrder.setTotalAmount(total);
    purchaseOrder.setNumberOfItems(items.size());
    Long poId = purchaseOrderDAO.createPurchaseOrder(purchaseOrder);

    return poId;

    /*Double total = 0.0;
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
                    throw new InsufficientQuantityException(("Item " + items.get(i).getName() + " is unavailable"));
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
            return poId;*/
  }
}
