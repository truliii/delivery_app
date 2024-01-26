package com.example.deliveryspring.Food;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Getter
@Setter
public class FoodDto extends Food{

    private long foodId;
    private String foodName;
    private int price;
    private String foodDescription;

}
