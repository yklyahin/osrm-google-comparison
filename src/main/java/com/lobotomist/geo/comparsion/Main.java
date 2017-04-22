package com.lobotomist.geo.comparsion;

import com.beust.jcommander.JCommander;
import com.lobotomist.geo.comparsion.Console.CompareCommand;

public class Main {
    public static void main(String[] args) throws Exception {
        CompareCommand command = new CompareCommand();
        JCommander commander = new JCommander();
        commander.addObject(command);
        commander.parse(args);
        command.run();
    }
}
