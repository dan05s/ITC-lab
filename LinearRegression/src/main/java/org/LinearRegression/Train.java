package org.LinearRegression;
import java.util.List;

public class Train {
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

    public float predict(float x){
        return getWeight()*x+getBias();
    }
    public float[] train(List<float[]> dataset,float lr,int epochs){
        for(int i=0;i<epochs;i++){
            float dw = 0;
            float db = 0;
            for(float[] data:dataset){
                float x=data[0];
                float y=data[1];
                float pr = predict(x);
                float error = pr - y;
                dw += error*x;
                db += error;
            }
            dw = dw/dataset.size();
            db = db/dataset.size();
            setWeight(getWeight()-lr*dw);
            setBias(getBias()-lr*db);
        }
        result[0] = getWeight();
        result[1] = getBias();
        return result;
    }
}