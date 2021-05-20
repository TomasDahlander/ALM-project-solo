package com.example.springdocker.service;

import com.example.springdocker.model.Car;
import com.example.springdocker.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CarService {
    private final CarRepository repository;

    public List<Car> getCars() {
        return repository.findAll();
    }

    public Car saveNewCar(Car car) {
        boolean carAlreadyExists = checkCarIfExists(car.getRegNr());
        if(carAlreadyExists) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Car already exist in database.");
        return repository.save(car);
    }

    private boolean checkCarIfExists(String regNr){
        if(regNr.length() != 7) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Reg nr must be in format XXX-XXX");
        Car existingCar = repository.findCarByRegNr(regNr);
        return existingCar != null;
    }

    public List<Car> saveNewCars(List<Car> cars) {
        List<Car> carsFromDB = new ArrayList<>();
        for(Car car : cars){
            carsFromDB.add(saveNewCar(car));
        }
        return carsFromDB;
    }

    public List<String> getConvertibleCars() {
        // Hämtar alla Cars som är convertables (cab)
        List<Car> cabbedCars = repository.findCarByConvertible(true);

        // Returnerar endast Car modellerna i en lista
        return cabbedCars.stream()
                .map(car -> car.getModel() + " " + car.getRegNr())
                .collect(Collectors.toList());
    }

    public List<Car> getCarsWithHigherHpThen(int hp) {
        // Hämtar alla cars
        List<Car> cars = repository.findAll();

        // Returnerar endast Cars med lika eller högre hp (horsepower).
        return cars.stream().filter(c -> c.getHorsePower() >= hp).collect(Collectors.toList());
    }

    public String deleteAllCars(){
        List<Car> list = repository.findAll();
        String message = "All cars below removed from database:\n";
        if(list.size() == 0) message = "No cars found in database.";
        else for(Car car : list) message += car.getModel() + " med reg nr " + car.getRegNr() +"\n";
        repository.deleteAll();
        return message;
    }
}
