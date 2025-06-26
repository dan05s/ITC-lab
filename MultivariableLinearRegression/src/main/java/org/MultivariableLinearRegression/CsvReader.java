package org.MultivariableLinearRegression;

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
            while((line= br.readLine())!=null){
                String[] lineArr = line.split(",");
                float x1 = Float.parseFloat(lineArr[0]);
                float x2 = Float.parseFloat(lineArr[1]);
                float x3 = Float.parseFloat(lineArr[2]);
                float y = Float.parseFloat(lineArr[3]);
                dataSet.add(new float[]{x1,x2,x3,y});
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return dataSet;
    }
}