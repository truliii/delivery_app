package com.example.deliveryspring.Food;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter //lombok 어노테이션 : 클래스 내 모든 필드의 Getter 메서드 자동 생성
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

}
