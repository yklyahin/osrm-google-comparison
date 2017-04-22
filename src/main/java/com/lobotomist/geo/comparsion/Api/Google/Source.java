package com.lobotomist.geo.comparsion.Api.Google;

import com.lobotomist.geo.comparsion.Api.*;
import com.lobotomist.geo.comparsion.ValueObject.Location;

public class Source implements SourceInterface {

    private String host = "http://maps.googleapis.com";
    private JsonClient client = new JsonClient();
    private RequestBuilder builder;

    public Source(RequestBuilder builder) {
        this.builder = builder;
    }

    public ApiResponse process(Location origin, Location destination) throws ProcessingException {
        String url = host + this.builder.build(origin, destination);

        Response response;

        try {
            response = client.doRequest(url, Response.class);
        } catch (Exception e) {
            throw new ProcessingException(e.getMessage(), this, e);
        }

        if (response.routes.length == 0) {
            throw new RouteNotExistsException(origin, destination, this);
        }

        return new ApiResponse("Google", response.routes[0].getShortestLeg().distance.value);
    }
}