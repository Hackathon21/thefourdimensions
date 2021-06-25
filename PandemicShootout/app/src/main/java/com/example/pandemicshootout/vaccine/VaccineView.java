package com.example.pandemicshootout.vaccine;

public class VaccineView {
    private float price;
    private long stock;
    private String name;
    private String storeName;

    public VaccineView(float price, long stock, String name, String storeName) {
        this.price = price;
        this.stock = stock;
        this.name = name;
        this.storeName = storeName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
