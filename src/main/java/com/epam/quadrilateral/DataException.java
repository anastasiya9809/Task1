package com.epam.quadrilateral;

public class DataException extends Exception {
    public DataException(String message, Exception e){
        super(message, e);
    }
}
