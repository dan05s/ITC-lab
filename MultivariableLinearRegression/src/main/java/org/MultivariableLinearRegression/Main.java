package org.MultivariableLinearRegression;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "src/main/resources/data.csv";
        CsvReader cr = new CsvReader();
        List<float[]> dataset = cr.readCsv(fileName);

        System.out.print("Enter w1,w2,w3: ");
        float w1 = sc.nextFloat();
        float w2 = sc.nextFloat();
        float w3 = sc.nextFloat();

        System.out.print("Enter bias: ");
        float bias = sc.nextFloat();

        float[] wb = new float[] {bias, w1, w2, w3};

        System.out.print("Enter epochs: ");
        int epochs = sc.nextInt();

        System.out.print("Enter learning rate: ");
        float lr = sc.nextFloat();

        Training tr = new Training();
        float[] result = new float[4];
        result = tr.train(wb,dataset,epochs,lr);
        System.out.printf("final model: %.2fx1 + %.2fx2 + %.2fx3 + %.2f",result[1],result[2],result[3],result[0]);

    }
}
