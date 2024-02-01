package com.example.deliveryspring.Restaurant;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RestaurantDto {

    private long restaurantId;

    @NotBlank
    private String restaurantName;

    @Positive //양수만
    private int category;

    @NotBlank
    private String address;

    @Pattern(regexp = "\\d{2,4}-\\d{3,4}-\\d{4}") //정규식
    private String phone;

    private String restaurantDescription;

    @Builder
    public RestaurantDto(long restaurantId, String restaurantName, int category, String address, String phone, String restaurantDescription){
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.category = category;
        this.address = address;
        this.phone = phone;
        this.restaurantDescription = restaurantDescription;
    }

    public Restaurant toEntity(RestaurantDto restaurantDto){
        return Restaurant.builder()
                .restaurantId(restaurantDto.getRestaurantId())
                .restaurantName(restaurantDto.getRestaurantName())
                .category(restaurantDto.getCategory())
                .address(restaurantDto.getAddress())
                .phone(restaurantDto.getPhone())
                .restaurantDescription(restaurantDto.getRestaurantDescription())
                .build();
    }

}
