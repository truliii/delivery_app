package com.example.deliveryspring.Order;

import com.example.deliveryspring.Food.Food;
import com.example.deliveryspring.User.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @Column
    private OrderStatus status;

    @Builder
    public Order (long id, User user, Food food, OrderStatus status){
        this.id = id;
        this.user = user;
        this.food = food;
        this.status = status;
    }

    public OrderDto toDto(Order order){
        return OrderDto.builder()
                .id(order.getId())
                .user(order.getUser())
                .food(order.getFood())
                .status(order.getStatus())
                .build();
    }

}
