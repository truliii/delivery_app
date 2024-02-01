package com.example.deliveryspring.Food;

import com.example.deliveryspring.Restaurant.Restaurant;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter //lombok 어노테이션 : 클래스 내 모든 필드의 Getter 메서드 자동 생성
@NoArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long foodId;

    @Column(nullable = false, length = 50)
    private String foodName;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String foodDescription;


    @Builder
    public Food(long foodId, String foodName, int price, String foodDescription){
        this.foodId = foodId;
        this.foodName = foodName;
        this.price = price;
        this.foodDescription = foodDescription;
    }

    public FoodDto toDto(Food food){
        return FoodDto.builder()
                .foodId(food.getFoodId())
                .foodName(food.getFoodName())
                .price(food.getPrice())
                .foodDescription(food.getFoodDescription())
                .build();
    }
}
