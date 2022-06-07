package com.sparta.w5_spring_homework.dto;

import com.sparta.w5_spring_homework.model.Order;
import com.sparta.w5_spring_homework.model.OrderFood;
import com.sparta.w5_spring_homework.model.Restaurant;
import com.sparta.w5_spring_homework.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private String restaurantName;  //음식점 이름
    private List<OrderFoodDto> foods;   // 음식점에 주문된 음식 리스트
    private int deliveryFee;    // 배달비
    private int totalPrice;     // 총 주문가격

    public OrderDto(String restaurantName, List<OrderFoodDto> orderFoodDtoList, Integer deliveryFee, Integer totalPrice){
        this.restaurantName = restaurantName;
        this.foods = orderFoodDtoList;
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice + deliveryFee;
    }


    public OrderDto(Restaurant restaurant, List<OrderFoodDto> orderFoodDtoList, Integer totalPrice){
        this.restaurantName = restaurant.getName();
        this.foods = orderFoodDtoList;
        this.deliveryFee = restaurant.getDeliveryFee();
        this.totalPrice = totalPrice + restaurant.getDeliveryFee();
    }

    // Dto 를 entity로 바꿔주는 함수를 사용하면 재사용성이 증가한다.
//    public Order toEntity(){
//        RestaurantRepository restaurantRepository;
//        return Order.builder()
//                .restaurant(restaurantRepository.findByName(restaurantName))
//                .foods(foods)
//                .
//
//    }
}
