package com.lobotomist.geo.comparsion.Configuration;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.lobotomist.geo.comparsion.Api.Google.RequestBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ComparatorFactory {
    public static com.lobotomist.geo.comparsion.Compare.Comparator fromYAML(String filepath) throws FileNotFoundException, YamlException {
        YamlReader reader = new YamlReader(new FileReader(filepath));
        return ComparatorFactory.build(reader.read(Config.class));
    }

    public static com.lobotomist.geo.comparsion.Compare.Comparator build(Config config) {
        com.lobotomist.geo.comparsion.Api.OSRM.Source osrmSource = new com.lobotomist.geo.comparsion.Api.OSRM.Source(config.osrm.host);
        com.lobotomist.geo.comparsion.Api.Google.Source googleSource;
        googleSource = new com.lobotomist.geo.comparsion.Api.Google.Source(RequestBuilder.createFromConfig(config.google));
        return new com.lobotomist.geo.comparsion.Compare.Comparator(osrmSource, googleSource);
    }
}