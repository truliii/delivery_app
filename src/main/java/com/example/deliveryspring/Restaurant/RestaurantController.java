package com.example.deliveryspring.Restaurant;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {

    private RestaurantService restaurantService;

    @Autowired
    RestaurantController(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    //전체 식당 조회
    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    public List<RestaurantDto> findAllRestaurant(){
        return restaurantService.findAllRestaurant();
    }

    //카테고리별 식당 조회
    @RequestMapping(value = "/restaurants/category/{category}", method = RequestMethod.GET)
    public List<RestaurantDto> findByCategory(@PathVariable("category") int category) {
        return restaurantService.findByCategory(category);
    }

    //단일 식당 조회
    @RequestMapping(value = "/restaurants/{id}", method = RequestMethod.GET)
    public RestaurantDto findRestaurant(@PathVariable("id") long id){
        return restaurantService.findRestaurant(id);
    }

    //단일 식당 등록
    @RequestMapping(value = "/restaurants", method = RequestMethod.POST)
    public void saveRestaurant(@RequestBody @Valid RestaurantDto restaurantDto){
        restaurantService.saveRestaurant(restaurantDto);
    }

    //단일 식당 수정
    @RequestMapping(value = "/restaurants", method = RequestMethod.PATCH)
    public void updateRestaurant(@RequestBody @Valid RestaurantDto restaurantDto){
        restaurantService.saveRestaurant(restaurantDto);
    }

    //단일 식당 삭제
    @RequestMapping(value = "/restaurants/{id}", method = RequestMethod.DELETE)
    public void deleteRestaurant(@PathVariable("id") long id){
        restaurantService.deleteRestaurant(id);
    }

}
