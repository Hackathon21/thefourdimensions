package com.example.pandemicshootout.vaccine;

public class VaccineView {
    private String name;
    private String pincode;
    private double latitude;
    private double longitude;
    private long age_limit;
    private String vaccine;

    public VaccineView(String name, String pincode, double latitude, double longitude, long age_limit, String vaccine) {
        this.name = name;
        this.pincode = pincode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.age_limit = age_limit;
        this.vaccine = vaccine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public long getAge_limit() {
        return age_limit;
    }

    public void setAge_limit(long age_limit) {
        this.age_limit = age_limit;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }
}
