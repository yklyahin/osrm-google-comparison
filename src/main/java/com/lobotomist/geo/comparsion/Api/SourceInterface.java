package com.lobotomist.geo.comparsion.Api;

import com.lobotomist.geo.comparsion.ValueObject.Location;

public interface SourceInterface {
    ApiResponse process(Location origin, Location destination) throws ProcessingException;
}