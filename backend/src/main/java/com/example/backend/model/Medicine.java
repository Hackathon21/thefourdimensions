package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Medicine {
    @Id
    private UUID id;
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Store> stores;
    private String name;
    private long stock;
    private float price;
    private String storeName;

    public Medicine(){
        this.id = UUID.randomUUID();
        this.stores = new ArrayList<>();
    }

    public Medicine(String name, long stock, float price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public void addStore(Store s){
        this.stores.add(s);
    }
}
