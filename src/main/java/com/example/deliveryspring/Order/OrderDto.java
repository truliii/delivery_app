package com.example.deliveryspring.Order;

import com.example.deliveryspring.Food.Food;
import com.example.deliveryspring.User.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderDto {

    private long id;

    @NotBlank
    private User user;

    @NotBlank
    private Food food;

    @NotBlank
    private OrderStatus status;

    @Builder
    public OrderDto (long id, User user, Food food, OrderStatus status){
        this.id = id;
        this.user = user;
        this.food = food;
        this.status = status;
    }

    public Order toEntity(OrderDto orderDto){
        return Order.builder()
                .id(orderDto.getId())
                .user(orderDto.getUser())
                .food(orderDto.getFood())
                .status(orderDto.getStatus())
                .build();
    }
}
