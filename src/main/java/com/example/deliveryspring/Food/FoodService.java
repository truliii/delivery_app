package com.example.deliveryspring.Food;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
            FoodDto foodDto = new FoodDto();
            BeanUtils.copyProperties(f, foodDto); //BeanUtils.copyProperties(source, target)
            foodList.add(foodDto);
        }
        return foodList;
    }

    //단일 음식 조회
    public FoodDto findFood(long id){
        Food food = foodRepository.findById(id).get();
        FoodDto foodDto = new FoodDto();
        BeanUtils.copyProperties(food, foodDto);
        return foodDto;
    }

    //단일 음식 등록
    public void saveFood(FoodDto foodDto){
        Food food = new Food();
        BeanUtils.copyProperties(foodDto, food);
        foodRepository.save(food);
    }

    //단일 음식 수정
    public void updateFood(FoodDto foodDto){
        Food food = new Food();
        BeanUtils.copyProperties(foodDto, food);
        foodRepository.save(food);
    }

    //단일 음식 삭제
    public void deleteFood(long id){
        foodRepository.deleteById(id);
    }

}
