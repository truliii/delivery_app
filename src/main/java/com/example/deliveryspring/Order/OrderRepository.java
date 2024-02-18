package com.example.deliveryspring.Order;

import com.example.deliveryspring.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    //사용자별 주문 조회
    List<Order> findByUser(User user);

    //단일 주문 조회
    @Override
    Optional<Order> findById(Long id);

    //단일 주문 등록, 수정
    @Override
    <S extends Order> S save(S order);
}
