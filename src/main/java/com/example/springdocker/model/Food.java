package com.example.springdocker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    String id;
    String name;
    boolean delicious;
    boolean canICookIt;

    public Food(String name, boolean delicious, boolean canICookIt) {
        this.name = name;
        this.delicious = delicious;
        this.canICookIt = canICookIt;
    }
}
