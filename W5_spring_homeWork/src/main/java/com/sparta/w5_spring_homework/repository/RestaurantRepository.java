package com.sparta.w5_spring_homework.repository;

import com.sparta.w5_spring_homework.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
//    Restaurant findById(Long id);
    Restaurant findByName(String restaurant_name);
}
