package com.example.deliveryspring.Food;

import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Getter
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_name")
    private long foodId;

    @Column(name = "food_name", nullable = false, length = 50)
    private String foodName;

    @Column(nullable = false)
    private int price;

    @Column(name = "food_description", nullable = false)
    private String foodDescription;

}
