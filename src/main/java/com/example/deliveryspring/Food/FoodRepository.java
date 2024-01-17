package com.example.deliveryspring.Food;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class FoodRepository {
    private Map<Integer, Food> db = new HashMap<>();
    private int id = 1;

    public void saveFood(Food food){
        db.put(id++, food);
    }

    public Food getFood(int idx){
        return db.get(idx);
    }
}
