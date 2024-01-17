package com.example.deliveryspring.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
    private FoodRepository foodRepository;

    @Autowired
    FoodService(FoodRepository foodRepository){
        this.foodRepository = foodRepository;
    }

    public void saveFood(Food food){
        foodRepository.saveFood(food);
    }

    public Food findFood(int id){
        return foodRepository.getFood(id);
    }
}
