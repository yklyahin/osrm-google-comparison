package com.lobotomist.geo.comparsion.Api.Google;

import com.lobotomist.geo.comparsion.ValueObject.Location;
import com.lobotomist.geo.comparsion.Configuration.GoogleSource;

public class RequestBuilder {

    private String departureTime;
    private String trafficModel;
    private Boolean alternatives;

    String build(Location origin, Location destination) {
        String url = "/maps/api/directions/json?origin=" + locationTransform(origin) + "&destination=" + locationTransform(destination) + "units=metric";

        if (departureTime != null) {
            url += "&departure_time=" + departureTime;
        }

        if (trafficModel != null) {
            url += "&traffic_model" + trafficModel;
        }

        if (alternatives != null) {
            url += "&alternatives=" + alternatives.toString();
        }

        return url;
    }

    private String locationTransform(Location location) {
        return location.getLatitude() + "," + location.getLongitude();
    }

    public static RequestBuilder createFromConfig(GoogleSource config) {
        RequestBuilder builder = new RequestBuilder();
        builder.departureTime = config.departure_time;
        builder.trafficModel = config.traffic_model;
        builder.alternatives = config.alternatives;
        return builder;
    }
}