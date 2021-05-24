package com.example.springdocker.service;

import com.example.springdocker.model.Food;
import com.example.springdocker.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FoodService {
    private final FoodRepository repository;

    public List<Food> getFoods() {
        return repository.findAll();
    }

    public Food saveNewFood(Food food) {
        return repository.save(food);
    }

    public List<Food> saveNewFoods(List<Food> foods) {
        return repository.saveAll(foods);
    }

    public List<String> getCookableFoods() {
        // hämtar alla Foods som vi kan laga
        List<Food> cookableFoods = repository.findFoodByCanICookIt(true);

        // returnerar endast Food namnen i en lista
        return cookableFoods.stream()
                .map(food -> food.getName())
                .collect(Collectors.toList());
    }


}
