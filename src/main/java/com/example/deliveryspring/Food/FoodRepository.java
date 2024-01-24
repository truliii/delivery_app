package com.example.deliveryspring.Food;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    //전체 음식 조회
    @Override
    List<Food> findAll();

    //단일 음식 조회
    @Override
    Optional<Food> findById(Long id);

    //단일 음식 등록, 수정
    @Override
    <S extends Food> S save(S food);

    //단일 음식 삭제
    @Override
    void deleteById(Long id);
}
