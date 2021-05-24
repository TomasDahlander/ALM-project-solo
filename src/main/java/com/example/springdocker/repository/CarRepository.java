package com.example.springdocker.repository;

import com.example.springdocker.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {

    List<Car> findCarByConvertible(boolean isConvertible);

    Car findCarByRegNr(String regNr);
}
