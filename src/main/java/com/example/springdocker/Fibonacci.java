package com.example.springdocker;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-05-14 <br>
 * Time: 09:22 <br>
 * Project: spring-docker-demo <br>
 */
public class Fibonacci {

    public int checkFib(int n){
        if(n < 0){
            throw new IndexOutOfBoundsException("Can not be a negative number");
        }
        if(n == 1 || n == 0){
            return n;
        }

        return checkFib(n-1) + checkFib(n-2);
    }
}
