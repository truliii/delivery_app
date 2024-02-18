package com.example.deliveryspring.Order;

import com.example.deliveryspring.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    //사용자별 주문 조회
    public List<OrderDto> findOrderByUser(User user){
        List<OrderDto> orderListByUser = new ArrayList<>();
        for(Order order : orderRepository.findByUser(user)){
            orderListByUser.add(order.toDto(order));
        }
        return orderListByUser;
    }

    //단일 주문 조회
    public OrderDto findOrder(long id){
        Order order = orderRepository.findById(id).get();
        return order.toDto(order);
    }

    //단일 주문 등록, 수정
    public void saveOrder(OrderDto orderDto){
        orderRepository.save(orderDto.toEntity(orderDto));
    }

}
