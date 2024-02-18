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
    private long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String foodDescription;

    @ManyToOne //N:1관계 매핑
    @JoinColumn(name="restaurant_id") //외래키 정의
    Restaurant restaurant;

    @Builder
    public Food(long id, String name, int price, String foodDescription, Restaurant restaurant){
        this.id = id;
        this.name = name;
        this.price = price;
        this.foodDescription = foodDescription;
        this.restaurant = restaurant;
    }

    public FoodDto toDto(Food food){
        return FoodDto.builder()
                .id(food.getId())
                .name(food.getName())
                .price(food.getPrice())
                .foodDescription(food.getFoodDescription())
                .restaurant(food.getRestaurant())
                .build();
    }
}

