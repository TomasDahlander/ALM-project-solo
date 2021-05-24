package com.example.springdocker.repository;

import com.example.springdocker.model.Food;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-05-14 <br>
 * Time: 13:15 <br>
 * Project: spring-docker-demo <br>
 */
@DataMongoTest
class FoodRepositoryTest {

    // vår klass vi vill testa
    @Autowired
    FoodRepository foodRepository;

    @Test
    public void findFoodByCanICookIt() {
        List<Food> list = Arrays.asList(
                new Food("1","Mango",true,true),
                new Food("2","Pear",false,false),
                new Food("3","Pineapple",true,false),
                new Food("4","Venison",true,true)
        );

        List<Food> expected = Arrays.asList(new Food("1","Mango",true,true),
                new Food("4","Venison",true,true));

        foodRepository.saveAll(list);

        List<Food> actual = foodRepository.findFoodByCanICookIt(true);

        assertEquals(expected, actual);
    }
}