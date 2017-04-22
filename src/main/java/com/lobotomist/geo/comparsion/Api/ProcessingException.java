package com.lobotomist.geo.comparsion.Api;

public class ProcessingException extends RuntimeException {

    private SourceInterface source;

    public ProcessingException(String message, SourceInterface source, Throwable throwable) {
        super(message, throwable);
        this.source = source;
    }

    public ProcessingException(String message, SourceInterface source) {
        super(message);
        this.source = source;
    }
}