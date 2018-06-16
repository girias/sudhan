package com.java.example.JavaSBA_BuyersSpot;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class PurchaseOrderDAO implements IPurchaseOrderDAO {

  @Override
  public Long createPurchaseOrder(PurchaseOrder purchaseOrderObj) {
    Long id = null;
    try {
      Connection dbconn = DBUtils.getConnection();
      Statement stmt = dbconn.createStatement();

      String poInsert =
          "insert into purchase_order(order_date,created_date,number_of_items, total_amount, customer_name, mobile_number) values ('"
              + new java.sql.Date(purchaseOrderObj.getOrderDate().getTime())
              + "','"
              + new java.sql.Date(purchaseOrderObj.getCreatedDate().getTime())
              + "',"
              + purchaseOrderObj.getNumberOfItems()
              + ","
              + purchaseOrderObj.getTotalAmount()
              + ",'"
              + purchaseOrderObj.getCustomerName()
              + "','"
              + purchaseOrderObj.getMobileNumber()
              + "')";

      //            System.out.println(poInsert);
      stmt.executeUpdate(poInsert);

      ResultSet rs = stmt.getGeneratedKeys();
      if (rs.next()) {
        id = rs.getLong(1);
      }

      List<OrderLine> lines = purchaseOrderObj.getOrderLineList();
      for (OrderLine ol : lines) {
        String olInsert =
            "insert into order_line(price,quantity,item_id,purchase_order_id) values ("
                + ol.getPrice()
                + ","
                + ol.getQuantity()
                + ","
                + ol.getItem().getId()
                + ","
                + id
                + ")";
        //                System.out.println(olInsert);
        stmt.executeUpdate(olInsert);

        // update
        String itemQtyUpdate =
            "update item set available_quantity="
                + (ol.getItem().getAvailableQuantity() - ol.getQuantity())
                + " where id="
                + ol.getItem().getId();
        stmt.executeUpdate(itemQtyUpdate);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return id;
  }
}
