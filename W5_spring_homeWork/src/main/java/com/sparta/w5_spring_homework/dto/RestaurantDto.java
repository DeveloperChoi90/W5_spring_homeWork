package com.sparta.w5_spring_homework.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RestaurantDto {

    private Long id;
    private String name; // restaurant 이름
    private Integer minOrderPrice; // 최소주문가격
    private Integer deliveryFee; // 배달비
}
