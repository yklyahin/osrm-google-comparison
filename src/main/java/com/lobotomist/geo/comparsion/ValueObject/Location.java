package com.lobotomist.geo.comparsion.ValueObject;

public class Location {

    private Coordinate latitude;
    private Coordinate longitude;

    public Location(double latitude, double longitude) {
        this.latitude = new Coordinate(latitude);
        this.longitude = new Coordinate(longitude);
    }

    public Location(Coordinate latitude, Coordinate longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Coordinate getLatitude() {
        return latitude;
    }

    public Coordinate getLongitude() {
        return longitude;
    }

}