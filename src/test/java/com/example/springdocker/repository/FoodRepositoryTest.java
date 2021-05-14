package com.example.springdocker.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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
    void findFoodByCanICookIt() {

    }
}