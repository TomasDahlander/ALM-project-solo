package com.example.springdocker.maths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-05-14 <br>
 * Time: 14:09 <br>
 * Project: spring-docker-demo <br>
 */
class MyMathCalcTest {

    MyMathCalc m;

    @BeforeEach
    public void init(){
        m = new MyMathCalc();
    }

    @Test
    public void addTest() {
        assertEquals(4,m.add(2,2));
        assertNotEquals(4,m.add(2,1));
    }

    @Test
    public void multiplyTest() {
        assertEquals(8,m.multiply(2,4));
        assertNotEquals(8,m.multiply(4,4));
    }

    @Test
    public void divideTest() {
        assertEquals(3,m.divide(9,3));
        assertNotEquals(3,m.divide(8,3));
    }

    @Test
    public void divideWith0Test() {
        assertThrows(ArithmeticException.class, () -> m.divide(9,0));
    }
}