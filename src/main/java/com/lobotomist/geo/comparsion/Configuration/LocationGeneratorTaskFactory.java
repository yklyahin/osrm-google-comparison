package com.lobotomist.geo.comparsion.Configuration;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.lobotomist.geo.comparsion.Generator.LocationGeneratorTask;

import java.io.FileReader;
import java.util.ArrayList;

public class LocationGeneratorTaskFactory {
    public static ArrayList<LocationGeneratorTask> fromYAML(String filepath) throws Exception {
        YamlReader reader = new YamlReader(new FileReader(filepath));
        return buid(reader.read(LocationTask.class));
    }

    public static ArrayList<LocationGeneratorTask> buid(LocationTask locationTask) {
        return new ArrayList<LocationGeneratorTask>(locationTask.converToGeneratorTasks());
    }
}