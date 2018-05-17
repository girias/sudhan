package com.java.example.javaSBA_MohanBuyerSpot;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO implements IITemDAO {

    @Override

    public List<Item> getAllItems() {

// TODO Auto-generated method stub

//return null;

        Connection conn;

        List<Item> itemList = new ArrayList<Item>();

        try {

            conn = DBUtils.getConnection();

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select * from item");

            while (rs.next())

            {

                itemList.add(new Item(Long.parseLong(rs.getString("id")), rs.getString("name"), Integer.parseInt(rs.getString("available_quantity")), Double.parseDouble(rs.getString("price"))));

            }

            stmt.close();

            conn.close();

            return itemList;

        } catch (ClassNotFoundException e) {

// TODO Auto-generated catch block

            e.printStackTrace();

        } catch (SQLException e) {

// TODO Auto-generated catch block

            e.printStackTrace();

        }

        return null;

    }

    public Item getItemById(long itemId)

    {

        Connection conn;

        Item item = null;

        try {

            conn = DBUtils.getConnection();

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select * from item where id='" + itemId + "'");

            while (rs.next())

            {

                item = new Item(Long.parseLong(rs.getString("id")), rs.getString("name"), Integer.parseInt(rs.getString("available_quantity")), Double.parseDouble(rs.getString("price")));

            }

            stmt.close();

            conn.close();

            return item;

        } catch (ClassNotFoundException e) {

// TODO Auto-generated catch block

            e.printStackTrace();

        } catch (SQLException e) {

// TODO Auto-generated catch block

            e.printStackTrace();

        }

        return null;

    }

}
