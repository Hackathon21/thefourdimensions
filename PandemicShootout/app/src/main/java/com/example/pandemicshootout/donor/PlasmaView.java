package com.example.pandemicshootout.donor;

public class PlasmaView {
    private String name;
    private String bloodGroup;
    private String validId;
    private String pincode;
    private String phoneNumber;

    public PlasmaView(String name, String bloodGroup, String validId, String city, String phoneNumber) {
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.validId = validId;
        this.pincode = city;
        this.phoneNumber = phoneNumber;
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

    public void setCity(String city) {
        this.pincode = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
