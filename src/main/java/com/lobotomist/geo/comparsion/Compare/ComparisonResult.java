package com.lobotomist.geo.comparsion.Compare;

import com.lobotomist.geo.comparsion.Api.ApiResponse;

import java.text.DecimalFormat;

public class ComparisonResult {
    private String name;

    private ApiResponse first;
    private ApiResponse second;

    ComparisonResult(String name, ApiResponse first, ApiResponse second) {
        this.name = name;
        this.first = first;
        this.second = second;
    }

    public String getName() {
        return name;
    }

    public ApiResponse getFirst() {
        return first;
    }

    public ApiResponse getSecond() {
        return second;
    }

    public float getDifference() {
        return first.getDistance() - second.getDistance();
    }
}