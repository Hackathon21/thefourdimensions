package com.example.pandemicshootout.bed;

public class BedView {
    private String name;
    private String contact;
    private long beds;
    private String latitude;
    private String longitude;

    public BedView(String name, String contact, long beds, String latitude, String longitude) {
        this.name = name;
        this.contact = contact;
        this.beds = beds;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public long getBeds() {
        return beds;
    }

    public void setBeds(long beds) {
        this.beds = beds;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
