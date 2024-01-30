package com.example.deliveryspring.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService {
    private FoodRepository foodRepository;

    @Autowired
    FoodService(FoodRepository foodRepository){
        this.foodRepository = foodRepository;
    }

    //전체 음식 조회
    public List<FoodDto> findAllFood(){
        List<FoodDto> foodList = new ArrayList<>();
        for(Food f : foodRepository.findAll()){
            FoodDto foodDto = FoodDto.builder()
                    .foodId(f.getFoodId())
                    .foodName(f.getFoodName())
                    .price(f.getPrice())
                    .foodDescription(f.getFoodDescription())
                    .build();
            foodList.add(foodDto);
        }
        return foodList;
    }

    //단일 음식 조회
    public FoodDto findFood(long id){
        Food food = foodRepository.findById(id).get();
        FoodDto foodDto = FoodDto.builder()
                .foodId(food.getFoodId())
                .foodName(food.getFoodName())
                .price(food.getPrice())
                .foodDescription(food.getFoodDescription())
                .build();
        return foodDto;
    }

    //단일 음식 등록
    public void saveFood(FoodDto foodDto){
        Food food = Food.builder()
                .foodId(foodDto.getFoodId())
                .foodName(foodDto.getFoodName())
                .price(foodDto.getPrice())
                .foodDescription(foodDto.getFoodDescription())
                .build();
        foodRepository.save(food);
    }

    //단일 음식 수정
    public void updateFood(FoodDto foodDto){
        Food food = Food.builder()
                .foodId(foodDto.getFoodId())
                .foodName(foodDto.getFoodName())
                .price(foodDto.getPrice())
                .foodDescription(foodDto.getFoodDescription())
                .build();
        foodRepository.save(food);
    }

    //단일 음식 삭제
    public void deleteFood(long id){
        foodRepository.deleteById(id);
    }

}
