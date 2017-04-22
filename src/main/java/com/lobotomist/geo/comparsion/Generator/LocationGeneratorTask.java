package com.lobotomist.geo.comparsion.Generator;

import com.lobotomist.geo.comparsion.ValueObject.Area;

public class LocationGeneratorTask {
    private String name;
    private Area area;
    private int iterations;

    public LocationGeneratorTask(String name, Area area, int iterations) {
        this.name = name;
        this.area = area;
        this.iterations = iterations;
    }

    public String getName() {
        return name;
    }

    public Area getArea() {
        return area;
    }

    public int getIterations() {
        return iterations;
    }
}
