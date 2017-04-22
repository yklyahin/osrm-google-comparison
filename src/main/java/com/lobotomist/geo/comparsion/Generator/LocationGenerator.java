package com.lobotomist.geo.comparsion.Generator;

import com.lobotomist.geo.comparsion.ValueObject.Area;
import com.lobotomist.geo.comparsion.ValueObject.Coordinate;
import com.lobotomist.geo.comparsion.ValueObject.Destination;
import com.lobotomist.geo.comparsion.ValueObject.Location;

import java.util.ArrayList;
import java.util.Random;

public class LocationGenerator implements LocationGeneratorInterface {
    private Random random = new Random();

    public ArrayList<Destination> generate(LocationGeneratorTask task) {
        ArrayList<Destination> destinations = new ArrayList<Destination>(task.getIterations());

        for (int i = 0; i < task.getIterations(); i++) {
            destinations.add(generate(task.getName(), task.getArea()));
        }

        return destinations;
    }

    public Destination generate(String name, Area area) {
        return new Destination(name, generateRandomLocation(area), generateRandomLocation(area));
    }

    protected Location generateRandomLocation(Area area) {
        return new Location(
                generateRandomPoint(area.getLeftTop().getLatitude(), area.getRightBottom().getLatitude()),
                generateRandomPoint(area.getRightBottom().getLongitude(), area.getLeftTop().getLongitude())
        );
    }

    protected Coordinate generateRandomPoint(Coordinate max, Coordinate min) {
        return new Coordinate((random.nextDouble() % (max.getValue() - min.getValue())) + min.getValue());
    }
}