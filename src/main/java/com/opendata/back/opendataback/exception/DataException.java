package com.opendata.back.opendataback.exception;

public class DataException extends RuntimeException {
    public DataException (String message) {
        super("Could not execute action on DB " + message);
    }
}
