package org.LinearRegression;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "src/main/resources/data2.csv";
        CsvReader cr = new CsvReader();
        List<float[]> dataset = cr.readCsv(fileName);
        System.out.print("Enter weight: ");
        float weight = sc.nextFloat();
        System.out.print("Enter bias: ");
        float bias = sc.nextFloat();
        System.out.print("Enter epochs: ");
        int epochs = sc.nextInt();
        System.out.print("Enter learning rate: ");
        float lr = sc.nextFloat();
        Train tr = new Train();
        float[] result = tr.train(weight,bias,dataset,lr,epochs);
        System.out.printf("Model function = %.4fx + %.4f\n",result[0],result[1]);
    }
}
