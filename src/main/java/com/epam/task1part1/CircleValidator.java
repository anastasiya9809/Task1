package com.epam.task1part1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CircleValidator {
    public boolean isCircle(String line){
        Pattern pattern = Pattern.compile(
                "^([1-9]|([1-9]\\d*\\.?\\d+)|(0\\.\\d*[1-9]\\d*))\\s-?(\\d|(\\d+\\.?\\d+))\\s-?(\\d|(\\d+\\.?\\d+))$");
        Matcher matcher = pattern.matcher(line);
        return matcher.find();
    }
}
