package com.sparta.w5_spring_homework.dto;

import com.sparta.w5_spring_homework.model.Food;
import com.sparta.w5_spring_homework.dto.OrderFoodRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderFoodDto {

    private String name;    // 주문한 음식
    private Integer quantity; // 주문음식 수량
    private Integer price;  // 주문한 음식의 총 가격

    public OrderFoodDto(Food food, Integer quantity){
        this.name = food.getName();
        this.quantity = quantity;
        this.price = food.getPrice() * quantity;
    }

    public OrderFoodDto(Food food, OrderFoodRequestDto orderFoodRequestDto){
        this.name = food.getName();
        this.quantity = orderFoodRequestDto.getQuantity();
        this.price = food.getPrice() * orderFoodRequestDto.getQuantity();
    }
}
