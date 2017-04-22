package com.lobotomist.geo.comparsion.Generator;

import com.lobotomist.geo.comparsion.ValueObject.Destination;

import java.util.ArrayList;

public interface LocationGeneratorInterface {
    ArrayList<Destination> generate(LocationGeneratorTask task);
}