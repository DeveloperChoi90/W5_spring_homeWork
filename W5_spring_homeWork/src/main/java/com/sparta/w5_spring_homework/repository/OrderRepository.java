package com.sparta.w5_spring_homework.repository;

import com.sparta.w5_spring_homework.dto.OrderDto;
import com.sparta.w5_spring_homework.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
