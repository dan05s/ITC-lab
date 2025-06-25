package org.LinearRegression;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    public List<float[]> readCsv(String filename) {
        List<float[]> dataSet = new ArrayList<>();

        try{
            File file = new File(filename);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            br.readLine();
            while((line=br.readLine())!=null){
                String[] lineArr = line.split(",");
                float x = Float.parseFloat(lineArr[0]);
                float y = Float.parseFloat(lineArr[1]);
                dataSet.add(new float[]{x, y});
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return dataSet;
    }
}