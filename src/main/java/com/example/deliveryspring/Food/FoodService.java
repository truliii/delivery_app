package com.example.deliveryspring.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

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

    public void updateFood(Food food, int id){
        foodRepository.updateFood(food, id);
    }

    public void deleteFood(int id){
        foodRepository.deleteFood(id);
    }

    public Map<Integer, Food> findAllFood(){
        return foodRepository.getAllFood();
    }
}
