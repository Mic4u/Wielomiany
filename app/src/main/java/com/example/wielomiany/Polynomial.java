package com.example.wielomiany;

import java.io.Serializable;
import java.util.Arrays;

public class Polynomial implements Serializable {

    double[] coefs;

    public Polynomial(String raw) {



        String [] medium = (raw.split(","));

        double[] inter=new double[medium.length];

        for(int i=0;i<medium.length;i++) {
            inter[i]=Double.valueOf(medium[i]);

        }

        this.coefs=inter;

    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        String znak="";

        for(int i=coefs.length;i>0;i--){

            if(coefs[coefs.length-i]>=0) znak="+";
            else znak="-";

            if(coefs[coefs.length-i]==0)

                stringBuilder.append("");

            else
            stringBuilder.append(coefs[coefs.length-i]+"x^"+i);

        }

        return stringBuilder.toString();
    }

    public String adress(){

        return this.toString().replace("^","%5E");

    }

    double calculate(double x){

        double result=0;

        for(int i=coefs.length;i>0;i--) result+=coefs[coefs.length-i]*Math.pow(x,i);

        return result;
    }

}
