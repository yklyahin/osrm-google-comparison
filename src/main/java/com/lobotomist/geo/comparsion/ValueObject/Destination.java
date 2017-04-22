package com.lobotomist.geo.comparsion.ValueObject;

public class Destination {

    private String name;
    private Location origin, destination;

    public Destination(String name, Location origin, Location destination) {
        this.name = name;
        this.origin = origin;
        this.destination = destination;
    }

    public String getName() {
        return name;
    }

    public Location getOrigin() {
        return origin;
    }

    public Location getDestination() {
        return destination;
    }
}
