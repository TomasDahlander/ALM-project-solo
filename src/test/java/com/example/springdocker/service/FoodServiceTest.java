package com.example.springdocker.service;

import com.example.springdocker.model.Food;
import com.example.springdocker.repository.FoodRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-05-14 <br>
 * Time: 10:37 <br>
 * Project: spring-docker-demo <br>
 */
//@RunWith(MockitoRunner.class) // JUnit 4
@ExtendWith(MockitoExtension.class) // JUnit 5
class FoodServiceTest {

    FoodService foodService;

    @Mock
    FoodRepository mockRepository;

    @BeforeEach
    public void init(){
        foodService = new FoodService(mockRepository);
    }

    @Test
    void getFoodsTest() {

        Food mockFood = new Food("Apple",true,true);

        when(mockRepository.findAll()).thenReturn(Arrays.asList(mockFood));

        // Anropa vår metod
        List<Food> foods = foodService.getFoods();

        assertEquals("Apple",foods.get(0).getName());
        assertEquals(1,foods.size());
        verify(mockRepository).findAll();

    }

    @Test
    void saveNewFoodTest() {
        Food mockFood = new Food("Apple",true,true);

        when(mockRepository.save(any())).thenReturn(mockFood);

        Food foodFromDB = foodService.saveNewFood(mockFood);

        assertEquals(mockFood.getName(),foodFromDB.getName());
        verify(mockRepository).save(any());

    }

    @Test
    @Disabled
    void getCookableFoodsTest() {
        Food mockFood1 = new Food("Apple",true,true);
        Food mockFood2 = new Food("Pear",false,false);

        List<Food> foods = Arrays.asList(mockFood1, mockFood2);

        when(mockRepository.saveAll(any())).thenReturn(foods);

        when(mockRepository.findFoodByCanICookIt(true)).thenReturn(Arrays.asList(mockFood1));

        List<Food> foodsFromDB = foodService.saveNewFoods(foods);


        verify(mockRepository).saveAll(any());

    }
}