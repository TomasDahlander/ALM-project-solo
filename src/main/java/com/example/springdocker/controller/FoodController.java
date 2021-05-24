package com.example.springdocker.controller;

import com.example.springdocker.model.Food;
import com.example.springdocker.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FoodController {
    private final FoodService service;

    @GetMapping("/foods")
    public List<Food> getFoods() {
        return service.getFoods();
    }

    @PostMapping("/foods")
    public Food saveNewFood(@RequestBody Food food) {
        return service.saveNewFood(food);
    }

    @PostMapping("/foods/list")
    public List<Food> saveNewFoods(@RequestBody List<Food> foods){
        return service.saveNewFoods(foods);
    }

    @GetMapping("/foods/cookable")
    public List<String> getCookableFoods() {
        return service.getCookableFoods();
    }
}
