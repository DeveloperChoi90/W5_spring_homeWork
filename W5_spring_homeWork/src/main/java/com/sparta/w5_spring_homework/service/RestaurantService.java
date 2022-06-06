package com.sparta.w5_spring_homework.service;


import com.sparta.w5_spring_homework.dto.RestaurantDto;
import com.sparta.w5_spring_homework.model.Restaurant;
import com.sparta.w5_spring_homework.repository.FoodRepository;
import com.sparta.w5_spring_homework.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;

    @Transactional
    public String registerRestaurant(RestaurantDto restaurantDto) {
        // 1. 음식점 중복 검사
        // 2. 최소주문가격 1000 이상 100000 이하  // 100 단위
        // 3. 기본 배달비 10000 이하 // 500 단위
        if (restaurantRepository.findByName(restaurantDto.getName()) != null) {
            throw new IllegalArgumentException("이미 존재하는 음식점 입니다.");
        } else if (restaurantDto.getMinOrderPrice() < 1000 || restaurantDto.getMinOrderPrice() > 100000 || restaurantDto.getMinOrderPrice()%100 != 0) {
            throw new IllegalArgumentException("최소 주문가격을 확인해 주세요. 1,000 이상 100,000 이하 100원 단위로만 입력 가능합니다.");
        }else if(restaurantDto.getDeliveryFee() > 10000 || restaurantDto.getDeliveryFee() % 500 != 0){
            throw new IllegalArgumentException("기본 배달비를 확인해 주세요. 10,000 이하, 500 단위로 입력 가능합니다.");
        }

        Restaurant restaurant = new Restaurant(restaurantDto);
        restaurantRepository.save(restaurant);
        return "음식점 등록 완료";
    }
}
