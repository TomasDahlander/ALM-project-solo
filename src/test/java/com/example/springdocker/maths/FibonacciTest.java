package com.example.springdocker.maths;

import com.example.springdocker.maths.Fibonacci;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-05-14 <br>
 * Time: 09:27 <br>
 * Project: spring-docker-demo <br>
 */
class FibonacciTest {

    Fibonacci f;

    @BeforeEach
    public void beforeEachMethod(){
        f = new Fibonacci();
    }

    @Test
    @DisplayName("when n is 0")
    public void fib0(){
        assertEquals(0,f.checkFib(0),"but expected should be 0");
    }

    @Test
    @DisplayName("when n is 1")
    public void fib1(){
        assertEquals(1,f.checkFib(1),"but expected should be 1");
    }

    @Test
    @DisplayName("when n is 3")
    public void fib3(){
        assertEquals(2,f.checkFib(3),"but expected should be 2");
    }

    @Test
    @DisplayName("when n is a negative number")
    public void fibThrows(){
        List<Integer> testCases = Arrays.asList(-1,-10,-100);
        for(int cases : testCases){
            assertThrows(IndexOutOfBoundsException.class, () -> f.checkFib(cases),"should throw an Exception");
        }
    }

    @Test
    @Disabled
    public void myDisabledTest(){
        // will fail if run
        fail();
    }

}