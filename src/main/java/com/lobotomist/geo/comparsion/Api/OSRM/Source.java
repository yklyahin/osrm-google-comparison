package com.lobotomist.geo.comparsion.Api.OSRM;

import com.lobotomist.geo.comparsion.Api.*;
import com.lobotomist.geo.comparsion.ValueObject.Location;

public class Source implements SourceInterface {

    private JsonClient client = new JsonClient();

    private String name = "OSRM";

    private String host;

    /**
     * @param name of provider
     * @param host and port 127.0.0.1:5555
     */
    public Source(String name, String host) {
        this.name = name;
        this.host = host;
    }

    public Source(String host) {
       this.host = host;
    }

    public ApiResponse process(Location origin, Location destination) throws ProcessingException {
        String url = host + "/route/v1/driving/" + origin.getLongitude().getValue() + "," + origin.getLatitude().getValue()
                + ";" + destination.getLongitude().getValue() + "," + destination.getLatitude().getValue() + "?overview=false";

        Response response;

        try {
            response = client.doRequest(url, Response.class);
        } catch (Exception e) {
            throw new ProcessingException(e.getMessage(), this, e);
        }

        Response.Route shortest = response.getShortestRoute();

        if (shortest == null) {
            throw new RouteNotExistsException(origin, destination, this);
        }

        return new ApiResponse(this.name, shortest.distance);
    }
}