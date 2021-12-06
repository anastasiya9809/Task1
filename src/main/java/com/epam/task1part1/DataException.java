package com.epam.task1part1;

public class DataException extends Exception {
    public DataException(String message, Exception e){
        super(message, e);
    }
}
