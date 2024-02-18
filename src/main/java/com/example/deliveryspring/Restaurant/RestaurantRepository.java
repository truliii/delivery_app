package com.example.deliveryspring.Restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    // 전체 음식 조회
    @Override
    List<Restaurant> findAll();

    //카테고리별 음식 조회
    List<Restaurant> findByCategory(RestaurantCategory category);

    //단일 음식 조회
    @Override
    Optional<Restaurant> findById(Long id);

    //단일 음식 등록, 수정
    @Override
    <S extends Restaurant> S save(S restaurant);

    //단일 음식 삭제
    @Override
    void deleteById(Long id);

}
