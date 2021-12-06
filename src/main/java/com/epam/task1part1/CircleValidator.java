package com.epam.task1part1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CircleValidator {
    private static final String REGEX = "^([1-9]|([1-9]\\d*\\.?\\d+)|(0\\.\\d*[1-9]\\d*))(\\s-?(\\d|(\\d+\\.?\\d+))){2}$";

    public boolean isCircle(String line){
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(line);
        return matcher.find();
    }
}
