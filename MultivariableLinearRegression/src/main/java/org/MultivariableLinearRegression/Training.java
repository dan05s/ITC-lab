package org.MultivariableLinearRegression;
import java.util.*;

public class Training {

    private float[] weightNBias = new float[4];

    public float[] getWeightNBias() {
        return weightNBias;
    }

    public void setWeightNBias(float[] weightNBias) {
        this.weightNBias = weightNBias;
    }

    public float[] error(float[][] x, float[] y) {
        float[] mulXW = calMtrMul(x, getWeightNBias());
        float[] error = new float[y.length];
        for (int i = 0; i < y.length; i++) {
            error[i] = mulXW[i] - y[i];
        }
        return error;
    }

    public float[] changeWb(float[] c, float[][] x) {
        float[] gradient = new float[4];
        int N = c.length;

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < N; j++) {
                gradient[i] += x[i][j] * c[j];
            }
            gradient[i] /= N;
        }

        for (int j = 0; j < N; j++) {
            gradient[3] += c[j];
        }
        gradient[3] /= N;

        return gradient;
    }

    public float[] calMtrMul(float[][] a,float[] b){
        float[] mulResult = new float[a.length];
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[0].length;j++){
                 mulResult[i] += a[i][j]*b[j];
            }
        }
        return mulResult;
    }

    public float[] train(float w, float b, List<float[]> data, int epochs, float lr){
        float[][] x = new float[3][data.get(0).length];
        float[] y = new float[data.get(3).length];
        for(int i=0; i<data.size();i++){
            float[] cn = data.get(i);
            if(i!=3){
                x[i] = cn;
            }else {
                y = cn;
            }
        }

        for(int epoch=0; epoch<epochs; epoch++){
            float[] error = error(x,y);
            float[] grad = changeWb(error,x);
            float[] current = getWeightNBias();

            for(int i=0; i<current.length; i++){
                current[i]-=lr*grad[i];
            }

            setWeightNBias(current);
        }
        return getWeightNBias();
    }
}
