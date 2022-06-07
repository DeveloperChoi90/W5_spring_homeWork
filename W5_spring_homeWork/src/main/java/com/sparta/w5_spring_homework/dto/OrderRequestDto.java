package com.sparta.w5_spring_homework.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {
    private Long restaurantId;   // 음식점 id
    private List<OrderFoodRequestDto> foods;    // 주문 음식 리스트
}
