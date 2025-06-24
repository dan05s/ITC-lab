package org.LinearRegression;

import java.io.*;
import java.util.*;

public class CsvReader {
    public static class XYData {
        public List<Double> xList;
        public List<Double> yList;

        public XYData(List<Double> xList, List<Double> yList) {
            this.xList = xList;
            this.yList = yList;
        }
    }

    public XYData readXY(String filename) {
        List<Double> xList = new ArrayList<>();
        List<Double> yList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] parts = line.trim().split(",");
                if (parts.length < 2) continue;

                try {
                    double x = Double.parseDouble(parts[0].trim());
                    double y = Double.parseDouble(parts[1].trim());
                    if (Double.isNaN(x) || Double.isNaN(y)) {
                        System.out.println("NaN data: " + Arrays.toString(parts));
                    }
                    xList.add(x);
                    yList.add(y);
                } catch (NumberFormatException e) {
                    System.out.println("Wrong numbers: " + Arrays.toString(parts));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new XYData(xList, yList);
    }
}