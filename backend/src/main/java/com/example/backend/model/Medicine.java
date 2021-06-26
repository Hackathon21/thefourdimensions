package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Medicine {
    @Id
    private UUID id;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Store store;
    private String name;
    private long stock;
    private float price;
    private String storeName;

    public Medicine(){
        this.id = UUID.randomUUID();
    }

    public Medicine(Store store, String name, long stock, float price) {
        this.storeName=store.getName();
        this.store = store;
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

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
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
}
