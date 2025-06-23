package src.lab2;

public class LinearRegression {
    private double w = 0;
    private double b = 0;

    public double predict(double x){
        return w*x+b;
    }
    public double computeCost(double[] x, double[] y){
        double cost =0;
        for(int i=0; i<x.length;i++){
            double hl = predict(x[i]);
            cost += Math.pow(hl-y[i],2);
        }
        return cost/x.length;
    }
    void train(double[] x, double[] y, double lr, int epochs){
        for(int i=0; i<epochs; i++){
            double dw = 0;
            double db = 0;
            for(int j=0;j<x.length;j++){
                double hl = predict(x[j]);
                double error = hl - y[j];
                dw += error*x[j];
                db += error;
            }
            dw = dw/x.length;
            db = dw/x.length;
            w = w - lr * dw;
            b = b - lr * db;
        }
    }

    
    public static void main(String[] args) {
        double[] x = {1, 2, 3, 4};
        double[] y = {3, 5, 7, 9};

        // 모델 생성
        LinearRegression model = new LinearRegression();

        // 학습 시작: learningRate=0.01, epochs=1000
        model.train(x, y, 0.01, 1000);

        // 최종 cost 출력
        double cost = model.computeCost(x, y);
        System.out.printf("최종 cost = %.6f%n", cost);
    }
}


