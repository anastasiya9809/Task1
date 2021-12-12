package com.epam.quadrilateral.logic;

import com.epam.quadrilateral.exception.DataException;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataReader {
    private static final Logger LOGGER = Logger.getLogger(Director.class);

    public List<String> read(String path) throws DataException {
        List<String> lines = new ArrayList<>();
        File file = new File(path);
        Scanner sc;

        try {
            sc = new Scanner(file);
        }
        catch (IOException e){
            LOGGER.error("problems accessing the file", e);
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
