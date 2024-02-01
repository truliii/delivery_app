package com.example.deliveryspring.Restaurant;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long restaurantId;

    @Column
    private String restaurantName;

    @Column
    private int category;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private String restaurantDescription;

    @Builder
    public Restaurant(long restaurantId, String restaurantName, int category, String address, String phone, String restaurantDescription){
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.category = category;
        this.address = address;
        this.phone = phone;
        this.restaurantDescription = restaurantDescription;
    }

    public RestaurantDto toDto(Restaurant restaurant){
        return RestaurantDto.builder()
                .restaurantId(restaurant.getRestaurantId())
                .restaurantName(restaurant.getRestaurantName())
                .category(restaurant.getCategory())
                .address(restaurant.getAddress())
                .phone(restaurant.getPhone())
                .restaurantDescription(restaurant.getRestaurantDescription())
                .build();
    }
}
