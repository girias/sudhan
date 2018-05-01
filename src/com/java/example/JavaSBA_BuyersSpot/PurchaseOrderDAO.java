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
            String poInsert = "insert into purchase_order(order_date,created_date,number_of_items, customer_name, mobile_number) values ('"
                    + purchaseOrderObj.getOrderDate() + "','"
                    + purchaseOrderObj.getCreatedDate() + "','"
                    + purchaseOrderObj.getNumberOfItems() + "','"
                    + purchaseOrderObj.getCustomerName() + "','"
                    + purchaseOrderObj.getMobileNumber() + "'";

            stmt.executeUpdate(poInsert);

            List<OrderLine> lines = purchaseOrderObj.getOrderLineList();
            for (OrderLine ol : lines) {
                String olInsert = "insert into order_line(price,quantity,item_id,purchase_order_id) values ('"
                        + ol.getPrice() + "','"
                        + ol.getPrice() + "','"
                        + ol.getQuantity() + "','"
                        + ol.getItem().getId() + "','"
                        + ol.getPurchaseOrder().getId() + "','";
                stmt.executeUpdate(olInsert);

            }
            String sql = "select id from purchase_order:";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                id = rs.getLong("id");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }
}
