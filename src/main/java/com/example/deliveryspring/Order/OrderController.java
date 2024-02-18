package com.example.deliveryspring.Order;

import com.example.deliveryspring.User.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private OrderService orderService;

    @Autowired
    OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    //사용자별 주문 조회
    @GetMapping (value = "/orders/user/{user}")
    public List<OrderDto> findAllOrdersByUser(@PathVariable("user") User user) {
        return orderService.findOrderByUser(user);
    }

    //단일 주문 조회
    @GetMapping(value = "/orders/{id}")
    public OrderDto findOrder(@PathVariable("id") Long id){
        return orderService.findOrder(id);
    }

    //단일 주문 등록
    @PostMapping(value = "/orders")
    public void saveOrder(@RequestBody @Valid OrderDto orderDto){
        orderService.saveOrder(orderDto);
    }

    //단일 주문 수정
    @PatchMapping(value = "/orders")
    public void updateOrder(@RequestBody @Valid OrderDto orderDto){
        orderService.saveOrder(orderDto);
    }

}
