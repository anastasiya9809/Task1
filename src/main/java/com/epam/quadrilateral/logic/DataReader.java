package com.epam.quadrilateral.logic;

import com.epam.quadrilateral.exception.DataException;

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
            throw new DataException(e.getMessage(), e);
        }

        boolean hasNextLine = sc.hasNextLine();
        while (hasNextLine) {
            String line = sc.nextLine();
            lines.add(line);

            hasNextLine = sc.hasNextLine();
        }

        return lines;
    }
}
