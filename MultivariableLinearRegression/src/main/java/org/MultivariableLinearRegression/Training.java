package org.MultivariableLinearRegression;
import java.util.*;

public class Training {
    private float[] parameter = {0,0,0,0};

    public float[] getParameter() {
        return parameter;
    }

    public void setParameter(float[] parameter) {
        this.parameter = parameter;
    }

    public float[] train(float[] weightBias, List<float[]> dataset, int epochs, float lr ){
        setParameter(weightBias);
        int m = dataset.size();
        int n = 3;
        float[][] X = new float[m][n+1];
        float[] y = new float[m];
        for(int i=0; i<m; i++){
            float[] row = dataset.get(i);
            X[i][0] = 1.0f;
            X[i][1] = row[0];
            X[i][2] = row[1];
            X[i][3] = row[2];
            y[i]= row[3];
        }

        for(int epoch = 0; epoch < epochs; epoch ++){
            float[] weight = getParameter();
            System.out.printf("Epoch %d: w0=%.4f, w1=%.4f, w2=%.4f, w3=%.4f\n", epoch, weight[0], weight[1], weight[2], weight[3]);
            float w0 = weight[0];
            float w1 = weight[1];
            float w2 = weight[2];
            float w3 = weight[3];

            float[] dw = new float[4];

            for(int i=0; i<m; i++){
                float predict = X[i][0]*w0 + X[i][1]*w1 + X[i][2]*w2 + X[i][3]*w3;
                float error = predict - y[i];
                for(int j=0; j<=3; j++){
                    dw[j] += error * X[i][j];
                }
            }
            float[] changeW = new float[4];
            changeW[0] = w0 - lr * dw[0] / m;
            changeW[1] = w1 - lr * dw[1] / m;
            changeW[2] = w2 - lr * dw[2] / m;
            changeW[3] = w3 - lr * dw[3] / m;
            setParameter(changeW);
        }
        return getParameter();
    }

}
