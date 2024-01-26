package com.example.deliveryspring.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@ResponseBody
public class FoodController {
    private FoodService foodService;

    @Autowired
    FoodController(FoodService foodService){
        this.foodService = foodService;
    }

    //전체 음식 조회
    @RequestMapping(value="/foods", method=RequestMethod.GET)
    public List<FoodDto> findAllFood(){
        return foodService.findAllFood();
    }

    //단일 음식 조회
    @RequestMapping(value="/foods/{id}", method=RequestMethod.GET)
    public FoodDto findFood(@PathVariable("id") long id){
        return foodService.findFood(id);
    }

    //단일 음식 등록
    @RequestMapping(value="/foods", method=RequestMethod.POST)
    public void saveFood(@RequestBody FoodDto foodDto){
        foodService.saveFood(foodDto);
    }

    //단일 음식 수정
    @RequestMapping(value="/foods", method=RequestMethod.PATCH)
    public void updateFood(@RequestBody FoodDto foodDto){
        foodService.updateFood(foodDto);
    }

    //단일 음식 삭제
    @RequestMapping(value="/foods/{id}", method=RequestMethod.DELETE)
    public void deleteFood(@PathVariable("id") long id){
        foodService.deleteFood(id);
    }

}
