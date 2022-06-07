package com.sparta.w5_spring_homework.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderFoodRequestDto {
    private Long id;    // 주문 음식 id
    private Integer quantity; // 주문 음식의 수량
}
