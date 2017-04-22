package com.lobotomist.geo.comparsion.Configuration;

import com.lobotomist.geo.comparsion.Generator.LocationGeneratorTask;
import com.lobotomist.geo.comparsion.ValueObject.Area;
import com.lobotomist.geo.comparsion.ValueObject.Location;

class LocationTaskElement {
    public String name;

    public double[][] bounds;

    public int iterations;

    public LocationGeneratorTask convertToGeneratorTask() {
        return new LocationGeneratorTask(
            name, new Area(
                    new Location(bounds[0][0], bounds[0][1]),
                    new Location(bounds[1][0], bounds[1][1])
            ), iterations
        );
    }
}