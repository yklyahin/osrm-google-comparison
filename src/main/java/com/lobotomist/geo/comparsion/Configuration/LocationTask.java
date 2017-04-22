package com.lobotomist.geo.comparsion.Configuration;

import com.lobotomist.geo.comparsion.Generator.LocationGeneratorTask;

import java.util.ArrayList;

public class LocationTask {
    public LocationTaskElement[] areas;

    public ArrayList<LocationGeneratorTask> converToGeneratorTasks() {
        ArrayList<LocationGeneratorTask> tasks = new ArrayList<LocationGeneratorTask>(areas.length);

        for (LocationTaskElement area : areas) {
            tasks.add(area.convertToGeneratorTask());
        }

        return tasks;
    }
}
