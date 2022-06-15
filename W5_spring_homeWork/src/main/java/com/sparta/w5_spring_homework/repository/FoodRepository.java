package com.sparta.w5_spring_homework.repository;

import com.sparta.w5_spring_homework.model.Food;
import com.sparta.w5_spring_homework.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface FoodRepository extends JpaRepository<Food, Long> {
    Food findByRestaurantAndName(Restaurant restaurant, String name); // 같은 음식점 같은 음식명 중복 불가
    Optional<Food> findByIdAndRestaurant(Long id, Restaurant restaurant); // 음식점에 등록된 음식 id로 Food 찾기
    List<Food> findByRestaurantId(Long restaurant_id);  // 음식점에 등록된 음식 가져오기
}
