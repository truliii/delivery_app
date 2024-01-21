package com.example.deliveryspring.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@ResponseBody
public class FoodController {
    private FoodService foodService;

    @Autowired
    FoodController(FoodService foodService){
        this.foodService = foodService;
    }

    //단일 음식 등록
    @RequestMapping(value="/foods", method=RequestMethod.POST)
    public void saveFood(@RequestBody Food food){
        foodService.saveFood(food);
    }

    //단일 음식 조회
    @RequestMapping(value="/foods/{id}", method=RequestMethod.GET)
    public Food findFood(@PathVariable("id") int id){
        return foodService.findFood(id);
    }

    //단일 음식 수정
    @RequestMapping(value="/foods/{id}", method=RequestMethod.PATCH)
    public void updateFood(@PathVariable("id") int id, @RequestBody Food food){
        foodService.updateFood(food, id);
    }

    //단일 음식 삭제
    @RequestMapping(value="/foods/{id}", method=RequestMethod.DELETE)
    public void deleteFood(@PathVariable("id") int id){
        foodService.deleteFood(id);
    }

    //전체 음식 조회
    @RequestMapping(value="/foods", method=RequestMethod.GET)
    public Map<Integer, Food> findAllFood(){
        return foodService.findAllFood();
    }

}
