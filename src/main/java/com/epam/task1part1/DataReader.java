package com.epam.task1part1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataReader {
    public List<String> read(String path) throws DataException {
        List<String> lines = new ArrayList<>();
        File file = new File(path);
        Scanner sc;

        try {
            sc = new Scanner(file);
        }
        catch (Exception e){
            throw new DataException("The given file path was invalid.");
        }

        while (sc.hasNextLine()){
            lines.add(sc.nextLine());
        }

        return lines;
    }
}
