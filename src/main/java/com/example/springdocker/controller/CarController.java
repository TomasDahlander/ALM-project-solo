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

    @PostMapping("/cars")
    public void saveNewCar(@RequestBody Car car) {
        service.saveNewCar(car);
    }

    @GetMapping("/cars/cabs")
    public List<String> getCabbedCars() {
        return service.getConvertibleCars();
    }

    @GetMapping("/cars/power/{hp}")
    public List<Car> getCarsWithHigherHp(@PathVariable int hp){
        return service.getCarsWithHigherHpThen(hp);
    }
}
