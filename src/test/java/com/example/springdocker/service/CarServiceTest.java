package com.example.springdocker.service;

import com.example.springdocker.model.Car;
import com.example.springdocker.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-05-14 <br>
 * Time: 16:37 <br>
 * Project: spring-docker-demo <br>
 */
@ExtendWith(MockitoExtension.class) // JUnit 5
class CarServiceTest {

    CarService carService;

    @Mock
    CarRepository mockRepository;

    @BeforeEach
    public void init(){
        carService = new CarService(mockRepository);
    }

    @Test
    public void getCars() {
        List<Car> mockCarList = Arrays.asList(
                new Car("1","ABC-123","Saab 93",150,150000,false),
                new Car("2","DEF-456","Porsche 911",250,300000,true)
        );

        when(mockRepository.findAll()).thenReturn(mockCarList);

        List<Car> cars = carService.getCars();

        assertEquals("ABC-123",cars.get(0).getRegNr());
        assertEquals("DEF-456",cars.get(1).getRegNr());
        assertEquals(2,cars.size());

        verify(mockRepository).findAll();
    }

    @Test
    public void saveNewCar() {
        Car mockCar = new Car("ABC-123","Saab 93",150,150000,false);

        when(mockRepository.save(any())).thenReturn(mockCar);
        Car carFromDB = carService.saveNewCar(mockCar);

        assertEquals(mockCar,carFromDB);
        verify(mockRepository).save(any());
    }

    @Test
    public void saveNewCars() {
        List<Car> mockCarList = Arrays.asList(
                new Car("1","ABC-123","Saab 93",150,150000,false),
                new Car("2","DEF-456","Porsche 911",250,300000,true)
        );

        when(mockRepository.saveAll(anyList())).thenReturn(mockCarList);
        List<Car> carsFromDB = carService.saveNewCars(mockCarList);

        assertEquals(mockCarList,carsFromDB);
        verify(mockRepository).saveAll(anyList());
    }

    @Test
    public void getConvertibleCars() {
    }

    @Test
    public void getCarsWithHigherHpThen() {
    }
}