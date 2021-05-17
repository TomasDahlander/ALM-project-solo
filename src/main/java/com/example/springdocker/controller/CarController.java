package com.example.springdocker.controller;

import com.example.springdocker.model.Car;
import com.example.springdocker.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CarController {
    private final CarService service;

    @GetMapping("/cars")
    public List<Car> getCars() {
        return service.getCars();
    }

    @PostMapping("/car")
    public Car saveNewCar(@RequestBody Car car) {
        return service.saveNewCar(car);
    }

    @PostMapping("/cars")
    public List<Car> saveNewCars(@RequestBody List<Car> cars){
        return service.saveNewCars(cars);
    }

    @GetMapping("/cars/cabs")
    public List<String> getCabbedCars() {
        return service.getConvertibleCars();
    }

    @GetMapping("/cars/power/{hp}")
    public List<Car> getCarsWithHigherHp(@PathVariable int hp){
        return service.getCarsWithHigherHpThen(hp);
    }

    @DeleteMapping("/cars/delete")
    public String deleteAllCars(){
        return service.deleteAllCars();
    }
}
