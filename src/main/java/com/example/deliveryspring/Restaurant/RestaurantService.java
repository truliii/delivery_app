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
        List<RestaurantDto> list = new ArrayList<>();
        for(Restaurant r : restaurantRepository.findAll()){
            RestaurantDto restaurantDto = RestaurantDto.builder()
                    .restaurantId(r.getRestaurantId())
                    .restaurantName(r.getRestaurantName())
                    .category(r.getCategory())
                    .address(r.getAddress())
                    .phone(r.getPhone())
                    .restaurantDescription(r.getRestaurantDescription())
                    .build();
            list.add(restaurantDto);
        }

        return list;
    }

    //카테고리별 식당 조회
    public List<RestaurantDto> findByCategory(int category){
        List<RestaurantDto> list = new ArrayList<>();
        for(Restaurant r : restaurantRepository.findByCategory(category)){
            RestaurantDto restaurantDto = RestaurantDto.builder()
                    .restaurantId(r.getRestaurantId())
                    .restaurantName(r.getRestaurantName())
                    .category(r.getCategory())
                    .address(r.getAddress())
                    .phone(r.getPhone())
                    .restaurantDescription(r.getRestaurantDescription())
                    .build();
            list.add(restaurantDto);
        }

        return list;
    }

    //단일 식당 조회
    public RestaurantDto findRestaurant(long id){
        Restaurant restaurant = restaurantRepository.findById(id).get();
        RestaurantDto restaurantDto = RestaurantDto.builder()
                .restaurantId(restaurant.getRestaurantId())
                .restaurantName(restaurant.getRestaurantName())
                .category(restaurant.getCategory())
                .address(restaurant.getAddress())
                .phone(restaurant.getPhone())
                .restaurantDescription(restaurant.getRestaurantDescription())
                .build();

        return restaurantDto;
    }

    //단일 식당 등록 및 수정
    public void saveRestaurant(RestaurantDto restaurantDto){
        Restaurant restaurant = Restaurant.builder()
                .restaurantId(restaurantDto.getRestaurantId())
                .restaurantName(restaurantDto.getRestaurantName())
                .category(restaurantDto.getCategory())
                .address(restaurantDto.getAddress())
                .phone(restaurantDto.getPhone())
                .restaurantDescription(restaurantDto.getRestaurantDescription())
                .build();

        restaurantRepository.save(restaurant);
    }

    //단일 식당 삭제
    public void deleteRestaurant(long id){
        restaurantRepository.deleteById(id);
    }
}
