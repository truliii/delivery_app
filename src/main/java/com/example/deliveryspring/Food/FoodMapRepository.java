package com.example.deliveryspring.Food;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

public class FoodMapRepository {
    private Map<Integer, Food> db = new HashMap<>();
    private int id = 1;

    public void saveFood(Food food){
        db.put(id++, food);
    }

    public Food getFood(int idx){
        return db.get(idx);
    }

    public void updateFood(Food food, int idx){
        db.replace(idx, food);
    }

    public void deleteFood(int idx){
        db.remove(idx);
    }

    public Map<Integer, Food> getAllFood(){
        return db;
    }
}
