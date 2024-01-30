package com.example.deliveryspring.Food;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class FoodDto{

    private long foodId;
    private String foodName;
    private int price;
    private String foodDescription;

    @Builder
    public FoodDto(long foodId, String foodName, int price, String foodDescription){
        this.foodId = foodId;
        this.foodName = foodName;
        this.price = price;
        this.foodDescription = foodDescription;
    }

}
