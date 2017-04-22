package com.lobotomist.geo.comparsion.Report;

import com.lobotomist.geo.comparsion.Compare.ComparisonResult;

import java.io.IOException;
import java.util.ArrayList;

public interface ReporterInterface {
    void report(ArrayList<ComparisonResult> comparisonResults) throws IOException;
}
