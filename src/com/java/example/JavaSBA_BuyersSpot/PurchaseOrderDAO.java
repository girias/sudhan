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

//            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            Date myDate = formatter.parse(date);
//            java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());


            String poInsert = "insert into purchase_order(order_date,created_date,number_of_items, total_amount, customer_name, mobile_number) values ('"
                    + new java.sql.Date(purchaseOrderObj.getOrderDate().getTime()) + "','"
                    + new java.sql.Date(purchaseOrderObj.getCreatedDate().getTime()) + "',"
                    + purchaseOrderObj.getNumberOfItems() + ","
                    + purchaseOrderObj.getTotalAmount() + ",'"
                    + purchaseOrderObj.getCustomerName() + "','"
                    + purchaseOrderObj.getMobileNumber() + "')";

            System.out.println(poInsert);
            stmt.executeUpdate(poInsert);

            List<OrderLine> lines = purchaseOrderObj.getOrderLineList();
            for (OrderLine ol : lines) {
                String olInsert = "insert into order_line(price,quantity,item_id,purchase_order_id) values ("
                        + ol.getPrice() + ","
                        + ol.getQuantity() + ","
                        + ol.getItem().getId() + ","
                        + ol.getPurchaseOrder().getId() + ")";
                System.out.println(olInsert);
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
