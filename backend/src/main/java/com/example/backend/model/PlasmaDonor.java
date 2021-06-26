package com.example.backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class PlasmaDonor {
    @Id
    private UUID uuid;
    private String name;
    private String bloodGroup;
    private String validId;
    private String pincode;
    private String phoneNumber;
    private boolean isEnabled;

    public PlasmaDonor() {
        this.uuid = UUID.randomUUID();
        this.isEnabled = true;
    }

    public PlasmaDonor(String name, String bloodGroup, String validId, String city, String phoneNumber) {
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.validId = validId;
        this.pincode = city;
        this.phoneNumber = phoneNumber;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getValidId() {
        return validId;
    }

    public void setValidId(String validId) {
        this.validId = validId;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String city) {
        this.pincode = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}
