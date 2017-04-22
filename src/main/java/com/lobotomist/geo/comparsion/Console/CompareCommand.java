package com.lobotomist.geo.comparsion.Console;

import com.beust.jcommander.Parameter;
import com.lobotomist.geo.comparsion.Compare.Comparator;
import com.lobotomist.geo.comparsion.Compare.ComparisonResult;
import com.lobotomist.geo.comparsion.Configuration.ComparatorFactory;
import com.lobotomist.geo.comparsion.Configuration.LocationGeneratorTaskFactory;
import com.lobotomist.geo.comparsion.Generator.LocationGenerator;
import com.lobotomist.geo.comparsion.Generator.LocationGeneratorInterface;
import com.lobotomist.geo.comparsion.Generator.LocationGeneratorTask;
import com.lobotomist.geo.comparsion.Report.CSVReporter;
import com.lobotomist.geo.comparsion.Report.ReporterInterface;
import com.lobotomist.geo.comparsion.ValueObject.Destination;

import java.io.IOException;
import java.util.ArrayList;

public class CompareCommand {

    @Parameter(names = "-r", required = true, description = "Path to report file")
    private String report = null;

    @Parameter(names = "-d", required = true, description = "Path to detailed report file")
    private String detailedReport = null;

    @Parameter(names = "-c", required = true, description = "Path to configuration")
    private String configuration = null;

    @Parameter(names = "-b", required = true, description = "Path to bounds")
    private String bounds = null;

    public void run() throws Exception {
        Comparator comparator = ComparatorFactory.fromYAML(this.configuration);
        LocationGeneratorInterface locationGenerator = this.getLocationGenerator();

        ArrayList<LocationGeneratorTask> tasks = LocationGeneratorTaskFactory.fromYAML(bounds);
        ArrayList<Destination> destinations = new ArrayList<Destination>();

        for (LocationGeneratorTask task : tasks) {
            destinations.addAll(locationGenerator.generate(task));
        }

        ArrayList<ComparisonResult> comparisonResults = comparator.compare(destinations);
        getReporter().report(comparisonResults);
    }

    protected ReporterInterface getReporter() throws IOException {
        return new CSVReporter(report, detailedReport);
    }

    protected LocationGeneratorInterface getLocationGenerator() {
        return new LocationGenerator();
    }
}