package com.example.springdocker.service;

import com.example.springdocker.model.Car;
import com.example.springdocker.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CarService {
    private final CarRepository repository;

    public List<Car> getCars() {
        return repository.findAll();
    }

    public void saveNewCar(Car car) {
        repository.save(car);
    }

    public List<String> getConvertibleCars() {
        // Hämtar alla Cars som är convertables (cab)
        List<Car> cabbedCars = repository.findCarByConvertible(true);

        // Returnerar endast Car modellerna i en lista
        return cabbedCars.stream()
                .map(car -> car.getModel())
                .collect(Collectors.toList());
    }

    public List<Car> getCarsWithHigherHpThen(int hp) {
        // Hämtar alla cars
        List<Car> cars = repository.findAll();

        // Returnerar endast Cars med lika eller högre hp.
        return cars.stream().filter(c -> c.getHorsePower() >= hp).collect(Collectors.toList());
    }
}
