package org.LinearRegression;
import java.util.List;

public class Train {
    private double weight = 0.0;
    private double bias = 0.0;

    public double getWeight() {
        return weight;
    }

    public double getBias() {
        return bias;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }

    public double predict(double x) {
        return weight * x + bias;
    }

    public void train(List<Double> x, List<Double> y, double lr, int epochs) {
        int m = x.size();

        for (int i = 0; i < epochs; i++) {
            double dw = 0;
            double db = 0;

            for (int j = 0; j < m; j++) {
                double xj = x.get(j);
                double yj = y.get(j);
                double prediction = predict(xj);
                double error = prediction - yj;
                dw += error * xj;
                db += error;
            }

            dw = dw / m;
            db = db / m;

            weight -= lr * dw;
            bias -= lr * db;
        }

        System.out.printf("Train result: %.4fx + %.4f%n", weight, bias);
    }
}