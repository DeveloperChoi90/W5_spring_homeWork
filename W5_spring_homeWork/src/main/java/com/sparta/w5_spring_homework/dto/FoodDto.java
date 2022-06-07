package com.sparta.w5_spring_homework.dto;

import com.sparta.w5_spring_homework.model.Food;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FoodDto {
    private Long id;
    private String name; // 음식명
    private Integer price; // 음식가격

    public FoodDto(Food food) {
        this.id = food.getId();
        this.name = food.getName();
        this.price = food.getPrice();
    }
}