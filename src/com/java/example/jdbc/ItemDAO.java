package com.java.example.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {


    private static final String GET_ALL_ITEMS = "select id, name, price from item";
    private static final String UPDATE_PRICE_BY_ID = "update item set price=";


    public List<Item> getAllItems() throws SQLException {
        Connection dbConnection = DbConnection.getConnection();
        Statement stmt = dbConnection.createStatement();
        ResultSet rs = stmt.executeQuery(GET_ALL_ITEMS);
        List<Item> items = new ArrayList<>();
        while (rs.next()) {
            Item item = new Item(rs.getString(1), rs.getString(2), rs.getDouble(3));
            items.add(item);
        }
        return items;
    }

    public void updateItemPrice(Item item, Double price) throws SQLException {
        Connection dbConnection = DbConnection.getConnection();
        Statement stmt = dbConnection.createStatement();
        stmt.execute("update item set price=" + price + " where id=" + item.getId());
    }
}
