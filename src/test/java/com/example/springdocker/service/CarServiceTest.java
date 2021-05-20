package com.example.springdocker.service;

import com.example.springdocker.model.Car;
import com.example.springdocker.model.Food;
import com.example.springdocker.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

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
    public void getCarsTest() {
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
    public void saveNewCarTest() {
        Car mockCar = new Car("ABC-123","Saab 93",150,150000,false);

        when(mockRepository.save(mockCar)).thenReturn(mockCar);
        Car carFromDB = carService.saveNewCar(mockCar);

        assertEquals(mockCar,carFromDB);
        verify(mockRepository).save(mockCar);
    }

    @Test
    public void saveNewCarsTest() {
        List<Car> mockCarList = Arrays.asList(
                new Car("1","ABC-123","Saab 93",150,150000,false),
                new Car("2","DEF-456","Porsche 911",250,300000,true)
        );

        when(mockRepository.save(mockCarList.get(0))).thenReturn(mockCarList.get(0));
        when(mockRepository.save(mockCarList.get(1))).thenReturn(mockCarList.get(1));

        List<Car> carsFromDB = carService.saveNewCars(mockCarList);

        assertEquals(mockCarList,carsFromDB);
        verify(mockRepository).save(mockCarList.get(0));
        verify(mockRepository).save(mockCarList.get(1));
    }

    @Test
    public void getConvertibleCarsTest() {
        List<Car> expected = Arrays.asList(new Car("2","DEF-456","Porsche 911",250,300000,true));

        when(mockRepository.findCarByConvertible(true)).thenReturn(expected);
        List<String> actual = carService.getConvertibleCars();

        assertEquals(expected.get(0).getModel() + " " + expected.get(0).getRegNr(),actual.get(0));
        verify(mockRepository).findCarByConvertible(true);
    }

    @Test
    public void getCarsWithHigherHpThen200Test() {
        List<Car> mockCarList = Arrays.asList(
                new Car("1","ABC-123","Saab 93",150,150000,false),
                new Car("2","DEF-456","Porsche 911",250,300000,true)
        );

        List<Car> expected = Arrays.asList(new Car("2","DEF-456","Porsche 911",250,300000,true));

        when(mockRepository.findAll()).thenReturn(mockCarList);

        List<Car> actual = carService.getCarsWithHigherHpThen(200);

        assertEquals(expected,actual);
    }

    @Test
    public void deleteAllCarsTest() {
        List<Car> mockCarList = Arrays.asList(
                new Car("1","ABC-123","Saab 93",150,150000,false),
                new Car("2","DEF-456","Porsche 911",250,300000,true)
        );

        when(mockRepository.findAll()).thenReturn(mockCarList);

        String expected = "All cars below removed from database:\n";
        expected += mockCarList.get(0).getModel() + " med reg nr " + mockCarList.get(0).getRegNr() +"\n";
        expected += mockCarList.get(1).getModel() + " med reg nr " + mockCarList.get(1).getRegNr() +"\n";

        String actual = carService.deleteAllCars();

        assertEquals(expected,actual);
        verify(mockRepository).deleteAll();
    }
}
