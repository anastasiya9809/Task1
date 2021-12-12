package com.epam.quadrilateral.exception;

public class DataException extends Exception {
    public DataException(String message, Exception e){
        super(message, e);
    }
}
