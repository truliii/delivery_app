package com.example.deliveryspring.Restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    //전체 식당 조회
    public List<RestaurantDto> findAllRestaurant(){
        List<RestaurantDto> allRestaurants = new ArrayList<>();
        for(Restaurant restaurant : restaurantRepository.findAll()){
            allRestaurants.add(restaurant.toDto(restaurant));
        }

        return allRestaurants;
    }

    //카테고리별 식당 조회
    public List<RestaurantDto> findByCategory(RestaurantCategory category){
        List<RestaurantDto> restaurantsByCategory = new ArrayList<>();
        for(Restaurant restaurant : restaurantRepository.findByCategory(category)){
            restaurantsByCategory.add(restaurant.toDto(restaurant));
        }
        return restaurantsByCategory;
    }

    //단일 식당 조회
    public RestaurantDto findRestaurant(long id){
        Restaurant restaurant = restaurantRepository.findById(id).get();
        return restaurant.toDto(restaurant);
    }

    //단일 식당 등록 및 수정
    public void saveRestaurant(RestaurantDto restaurantDto){
        restaurantRepository.save(restaurantDto.toEntity(restaurantDto));
    }

    //단일 식당 삭제
    public void deleteRestaurant(long id){
        restaurantRepository.deleteById(id);
    }
}
