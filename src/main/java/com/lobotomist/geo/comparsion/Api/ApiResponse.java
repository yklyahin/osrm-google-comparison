package com.lobotomist.geo.comparsion.Api;

public class ApiResponse {

    private String source;

    private float distance;

    /**
     * @param source provider name
     * @param distance in meters
     */
    public ApiResponse(String source, float distance) {
        this.source = source;
        this.distance = distance;
    }

    public String getSource() {
        return source;
    }

    public float getDistance() {
        return distance;
    }
}