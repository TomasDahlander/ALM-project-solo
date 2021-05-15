package com.example.springdocker.repository;


import com.example.springdocker.model.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-05-14 <br>
 * Time: 16:18 <br>
 * Project: spring-docker-demo <br>
 */
@DataMongoTest
class CarRepositoryTest {

    @Autowired
    CarRepository carRepository;

    @Test
    public void findCarByConvertibleTest() {

        List<Car> list = Arrays.asList(
                new Car("1","ABC-123","Saab 93",150,150000,false),
                new Car("2","DEF-456","Porsche 911",250,300000,true)
        );

        List<Car> expected = Arrays.asList(new Car("2","DEF-456","Porsche 911",250,300000,true));

        carRepository.saveAll(list);

        List<Car> actual = carRepository.findCarByConvertible(true);

        assertEquals(expected, actual);
    }

    @Test
    public void findCarByRegNrTest() {
        Car mockCar = new Car("1","ABC-123","Saab 93",150,150000,false);

        carRepository.save(mockCar);

        Car carFromDB = carRepository.findCarByRegNr("ABC-123");
        assertEquals(mockCar,carFromDB);

        Car carNotExisting = carRepository.findCarByRegNr("DEF-123");
        assertNull(carNotExisting);
    }
}