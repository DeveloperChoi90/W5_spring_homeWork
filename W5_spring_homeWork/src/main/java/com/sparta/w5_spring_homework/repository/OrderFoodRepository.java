package com.sparta.w5_spring_homework.repository;

import com.sparta.w5_spring_homework.model.OrderFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderFoodRepository extends JpaRepository<OrderFood, Long> {

}
