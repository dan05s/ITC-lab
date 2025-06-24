package org.LinearRegression;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        String fileName = sc.next();
        CsvReader cr = new CsvReader();
        List<float[]> dataset = cr.readCsv(fileName);
        System.out.print("Enter epochs: ");
        int epochs = sc.nextInt();
        System.out.print("Enter learning rate: ");
        float lr = sc.nextFloat();
        Train tr = new Train();
        float[] result = tr.train(dataset,lr,epochs);
        System.out.println("cost function = "+result[0]+"x + "+result[1]);
    }
}
