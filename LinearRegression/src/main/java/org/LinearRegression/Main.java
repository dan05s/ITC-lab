package org.LinearRegression;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        String fileName = sc.next();
        CsvReader reader = new CsvReader();
        CsvReader.XYData data = reader.readXY(fileName);
        System.out.print("Enter epochs: ");
        int epochs = sc.nextInt();
        System.out.print("Enter learning rate: ");
        double lr = sc.nextDouble();
        Train tr = new Train();
        tr.train(data.xList,data.yList,lr,epochs);
    }
}
