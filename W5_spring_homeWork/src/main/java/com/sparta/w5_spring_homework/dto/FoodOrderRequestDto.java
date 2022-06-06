package com.sparta.w5_spring_homework.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodOrderRequestDto {
    Long id;
    int quantity;
}
