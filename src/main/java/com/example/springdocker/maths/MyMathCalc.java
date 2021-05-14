package com.example.springdocker.maths;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-05-12 <br>
 * Time: 15:27 <br>
 * Project: spring-docker-demo <br>
 */
public class MyMathCalc {

    public int add(int a, int b){
        return a+b;
    }

    public int multiply(int a, int b){
        return a*b;
    }

    public double divide(double a, double b){
        if(b == 0) throw new ArithmeticException("Cant divide by zero");
        return a/b;
    }

}
