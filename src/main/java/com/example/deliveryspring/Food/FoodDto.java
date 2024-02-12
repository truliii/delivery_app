package com.example.deliveryspring.Food;

import com.example.deliveryspring.Restaurant.Restaurant;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class FoodDto{

    private long id;
    private String name;
    private int price;
    private String foodDescription;
    private Restaurant restaurant;

    @Builder
    public FoodDto(long id, String name, int price, String foodDescription, Restaurant restaurant){
        this.id = id;
        this.name = name;
        this.price = price;
        this.foodDescription = foodDescription;
        this.restaurant = restaurant;
    }

    public Food toEntity(FoodDto foodDto){
        return Food.builder()
                .id(foodDto.getId())
                .name(foodDto.getName())
                .price(foodDto.getPrice())
                .foodDescription(foodDto.getFoodDescription())
                .restaurant(foodDto.getRestaurant())
                .build();
    }
}
