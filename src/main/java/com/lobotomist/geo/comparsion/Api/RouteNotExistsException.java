package com.lobotomist.geo.comparsion.Api;

import com.lobotomist.geo.comparsion.ValueObject.Location;

public class RouteNotExistsException extends ProcessingException {

    private Location origin, destination;

    public RouteNotExistsException(Location origin, Location destination, SourceInterface source) {
        super("Route not exists", source);
        this.origin = origin;
        this.destination = destination;
    }

    public Location getOrigin() {
        return origin;
    }

    public Location getDestination() {
        return destination;
    }
}
