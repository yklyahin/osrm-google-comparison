package com.lobotomist.geo.comparsion.Compare;

import com.lobotomist.geo.comparsion.Api.SourceInterface;
import com.lobotomist.geo.comparsion.ValueObject.Destination;
import com.lobotomist.geo.comparsion.Api.RouteNotExistsException;

import java.util.ArrayList;

public class Comparator {
    private SourceInterface first, second;

    public Comparator(SourceInterface first, SourceInterface second) {
        this.first = first;
        this.second = second;
    }

    public ArrayList<ComparisonResult> compare(ArrayList<Destination> destinations) {
        ArrayList<ComparisonResult> results = new ArrayList<ComparisonResult>();

        for (Destination destination : destinations) {
            try {
                results.add(new ComparisonResult(
                        destination.getName(),
                        this.first.process(destination.getOrigin(), destination.getDestination()),
                        this.second.process(destination.getOrigin(), destination.getDestination())
                ));
            } catch (RouteNotExistsException e) {
                System.out.print(e.getMessage());
            }
        }

        return results;
    }
}
