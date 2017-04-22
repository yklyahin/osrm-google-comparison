package com.lobotomist.geo.comparsion.Api.OSRM;

public class Response {
    protected Route[] routes;

    protected class Route {
        protected float distance;
    }

    public Route getShortestRoute() {
        Route shortest = null;

        for (Route route : routes) {
            if (shortest == null || shortest.distance > route.distance) {
                shortest = route;
            }
        }

        return shortest;
    }
}
