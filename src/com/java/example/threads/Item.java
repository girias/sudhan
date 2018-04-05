package com.java.example.threads;

public class Item {
    Long itemId;
    String name;
    String provider;
    Double price;
    Double rating;

    public Item(Long itemId, String name, String provider, Double price, Double rating) {
        this.itemId = itemId;
        this.name = name;
        this.provider = provider;
        this.price = price;
        this.rating = rating;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    @SuppressWarnings("deprecation")
    public String toString() {
        //Override the toString method, such that it returns the provider, price and rating of the item.
        return (this.provider + "," + (this.price).toString() + "," + (this.rating).toString());
    }
}
