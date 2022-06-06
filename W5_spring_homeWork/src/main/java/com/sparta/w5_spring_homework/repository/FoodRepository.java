package com.sparta.w5_spring_homework.repository;

import com.sparta.w5_spring_homework.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {
    Optional<Food> findById(Long food_id);
    List<Food> findAllByRestaurant(Long restaurant_id);
}
