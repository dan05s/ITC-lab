package org.LinearRegression;
import java.util.List;

public class Training {
    private float weight = 0;
    private float bias = 0;
    private float[] result = {0,0};

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getBias() {
        return bias;
    }

    public void setBias(float bias) {
        this.bias = bias;
    }

    public float predict(float x){  //return predict value
        return getWeight()*x+getBias();
    }

    public float[] calGradient(float[] x, float[] y){   //calculate gradient
        //cost(w,b) = 오차의 제곱의 합의 평균, w=(오차*특정 인덱스 x값)의 합의 평균*2, b= 오차의 합의 평균*2
        float dw = 0;
        float db = 0;
        float cost = 0;
        int m = x.length;

        for(int i = 0; i < m; i++){
            float h = predict(x[i]);
            float error = h - y[i];
            cost += error * error;  //cost value = error^2
            dw += error * x[i]; //w value accumulation
            db += error;    //b value accumulation
        }

        float[] gradient = new float[3];
        gradient[0] = (2f / m) * dw;   //dW
        gradient[1] = (2f / m) * db;   //dB
        return gradient;
    }

    public void changeWb(float[] gradient , float lr){
        float nw = getWeight() - lr*gradient[0];
        float nb = getBias() - lr*gradient[1];
        setWeight(nw);
        setBias(nb);
    }

    public float[] train(float w, float b,List<float[]> dataset,float lr,int epochs){
        setWeight(w);
        setBias(b);

        float[] x = dataset.get(0);
        float[] y = dataset.get(1);
        float[] calResult;

        for(int i=0;i<epochs;i++){
            calResult= calGradient(x,y);
            changeWb(calResult,lr);
            System.out.printf("epoch = %d, w = %.4f , b = %.4f\n",i+1,getWeight(),getBias());
        }
        result[0] = getWeight();
        result[1] = getBias();
        return result;
    }
}