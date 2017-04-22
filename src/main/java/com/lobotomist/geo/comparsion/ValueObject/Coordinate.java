package com.lobotomist.geo.comparsion.ValueObject;

public class Coordinate {

    private double coordinate;

    public Coordinate(double coordinate) {
        this.coordinate = coordinate;
    }

    public double getValue() {
        return coordinate;
    }

    public String toString() {
        return String.valueOf(coordinate);
    }
}