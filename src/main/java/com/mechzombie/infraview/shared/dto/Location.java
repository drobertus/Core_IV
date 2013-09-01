package com.mechzombie.infraview.shared.dto;

/**
 * Created with IntelliJ IDEA.
 * User: david
 * Date: 8/31/13
 * Time: 9:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Location {

    private double latitude;
    private double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
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
}
