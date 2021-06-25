package com.example.backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Store {
    @Id
    private UUID id;
    private String name;
    private String address;
    private String phoneNumber;
    private String filename;

    public Store() {
    }

    public Store(String name, String address, String phoneNumber, String filename) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.filename = filename;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
