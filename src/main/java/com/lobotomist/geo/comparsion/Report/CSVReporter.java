package com.lobotomist.geo.comparsion.Report;

import com.lobotomist.geo.comparsion.Api.ApiResponse;
import com.lobotomist.geo.comparsion.Compare.ComparisonResult;
import org.supercsv.io.CsvListWriter;
import org.supercsv.io.ICsvListWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CSVReporter implements ReporterInterface {
    private ICsvListWriter reportWriter, detailsWriter;

    public CSVReporter(String reportPath, String detailsPath) throws IOException {
        reportWriter = createReportWriter(reportPath);
        detailsWriter = createDetailsWriter(detailsPath);
    }

    public void report(ArrayList<ComparisonResult> comparisonResults) throws IOException {
        reportWriter.write(this.reportHead());
        detailsWriter.write(this.detailsHead());

        Map<String, Integer> scores = new HashMap<String, Integer>();

        for (ComparisonResult comparisonResult : comparisonResults) {
            ApiResponse winner;

            if (comparisonResult.getDifference() < 0) {
                winner = comparisonResult.getFirst();
            } else {
                winner = comparisonResult.getSecond();
            }

            if (winner != null) {
                String winnerName = winner.getSource();
                Integer winnerScores = scores.containsKey(winnerName)
                        ? scores.get(winnerName)
                        : 0;

                scores.put(winnerName, winnerScores + 1);
            }

            detailsWriter.write(body(comparisonResult));
        }

        for (HashMap.Entry<String, Integer> source : scores.entrySet()) {
            this.reportWriter.write(source.getKey(), source.getValue());
        }

        reportWriter.flush();
        detailsWriter.flush();
    }

    protected String[] body(ComparisonResult comparisonResult) {
        return new String[]{
                comparisonResult.getName(),
                comparisonResult.getFirst().getSource() + " - " + comparisonResult.getFirst().getDistance() + "m",
                comparisonResult.getSecond().getSource() + " - " + comparisonResult.getSecond().getDistance() + "m",
                String.valueOf(Math.round(comparisonResult.getDifference())) + "m"
        };
    }

    protected String[] reportHead() {
        return new String[]{"Processor", "Wins"};
    }

    protected String[] detailsHead() {
        return new String[]{"Name", "Processor", "Processor", "Difference", "Debug"};
    }


    protected ICsvListWriter createReportWriter(String filepath) throws IOException {
        return new CsvListWriter(new FileWriter(filepath), CsvPreference.STANDARD_PREFERENCE);
    }

    protected ICsvListWriter createDetailsWriter(String filepath) throws IOException {
        CsvPreference preference = new CsvPreference.Builder('"', '|', "\r\n")
                .build();

        return new CsvListWriter(new FileWriter(filepath), preference);
    }
}
