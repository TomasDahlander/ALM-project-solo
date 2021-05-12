package com.example.springdocker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    String regNr;
    String model;
    int horsePower;
    double price;
    boolean convertible; // cab
}
