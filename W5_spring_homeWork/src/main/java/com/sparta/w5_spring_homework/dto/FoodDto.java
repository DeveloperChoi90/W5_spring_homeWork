package com.sparta.w5_spring_homework.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FoodDto {
    private Long id;
    private String name; // 음식명
    private Integer price; // 음식가격
}