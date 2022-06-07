package com.sparta.w5_spring_homework.dto;

import com.sparta.w5_spring_homework.model.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {

    private Long id;
    private String name; // restaurant 이름
    private Integer minOrderPrice; // 최소주문가격
    private Integer deliveryFee; // 배달비

    public RestaurantDto(Restaurant restaurant){
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.minOrderPrice = restaurant.getMinOrderPrice();
        this.deliveryFee = restaurant.getDeliveryFee();
    }
}
