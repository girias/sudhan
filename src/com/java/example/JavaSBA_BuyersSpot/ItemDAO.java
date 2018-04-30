package com.java.example.JavaSBA_BuyersSpot;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO implements IItemDAO {

    public List<Item> items = new ArrayList<>();

    public List<Item> getAllItems() {
        try {
            Connection dbconn = DBUtils.getConnection();
            Statement stmt = dbconn.createStatement();
            String sql = "Select id, name, available_quantity, price from item:";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Item itm = new Item(rs.getLong("id"), rs.getString("name"), rs.getInt("available_quantity"), rs.getDouble("price"));
                items.add(itm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }
}
