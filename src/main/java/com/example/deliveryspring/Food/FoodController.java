package com.example.deliveryspring.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class FoodController {
    private FoodService foodService;

    @Autowired
    FoodController(FoodService foodService){
        this.foodService = foodService;
    }

    @RequestMapping(value="/foods", method=RequestMethod.POST)
    public void saveFood(@RequestBody Food food){
        System.out.println("POST");
        foodService.saveFood(food);
    }

    @RequestMapping(value="/foods/{id}", method=RequestMethod.GET)
    public Food findFood(@PathVariable("id") int id){
        return foodService.findFood(id);
    }

}
