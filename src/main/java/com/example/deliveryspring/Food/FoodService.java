package com.example.deliveryspring.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    private FoodRepository foodRepository;

    @Autowired
    FoodService(FoodRepository foodRepository){
        this.foodRepository = foodRepository;
    }

    //단일 음식 등록
    public void saveFood(Food food){
        foodRepository.save(food);
    }

    //단일 음식 조회
    public Optional<Food> findFood(long id){
        return foodRepository.findById(id);
    }

    //단일 음식 수정
    public void updateFood(Food food){
        foodRepository.save(food);
    }

    //단일 음식 삭제
    public void deleteFood(long id){
        foodRepository.deleteById(id);
    }

    //전체 음식 조회
    public List<Food> findAllFood(){
        return foodRepository.findAll();
    }
}
