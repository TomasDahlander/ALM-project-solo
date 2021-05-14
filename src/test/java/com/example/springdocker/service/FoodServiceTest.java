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
    void getCookableFoodsTest() {
        List<Food> list = Arrays.asList(
                new Food("Mango",true,true),
                new Food("Venison",true,true)
        );

        List<String> expected = Arrays.asList("Mango","Venison");

        when(mockRepository.findFoodByCanICookIt(anyBoolean())).thenReturn(list);

        List<String> actual = foodService.getCookableFoods();

        assertEquals(expected, actual);

    }
}