package com.sparta.w5_spring_homework.service;

import com.sparta.w5_spring_homework.dto.FoodDto;
import com.sparta.w5_spring_homework.model.Food;
import com.sparta.w5_spring_homework.model.Restaurant;
import com.sparta.w5_spring_homework.repository.FoodRepository;
import com.sparta.w5_spring_homework.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;


    // TODO: 2022/06/07
    // 음식 등록 및 조회 서비스
    @Transactional
    public void registerFood(Long restaurant_id, List<FoodDto> foodDtoList){

        Restaurant restaurant = restaurantRepository.findById(restaurant_id).orElseThrow(() -> new IllegalArgumentException("해당 음식점이 존재하지 않습니다."));
        for (FoodDto foodDto : foodDtoList) {
            if(foodRepository.findByRestaurantAndName(restaurant, foodDto.getName()) != null) throw new IllegalArgumentException("음식이 등록되어 있습니다.");
            else if( foodDto.getPrice() < 100 || foodDto.getPrice() > 1000000) throw new IllegalArgumentException("음식의 가격은 100원 ~ 1,000,000원 사이의 가격이여야 합니다.");
            else if(foodDto.getPrice() % 100 != 0) throw new IllegalArgumentException("100 원 단위로 입력해주세요.");

            Food food = new Food(restaurant, foodDto.getName(), foodDto.getPrice());
            foodRepository.save(food);
        }
    }

    @Transactional(readOnly = true)
    public List<FoodDto> searchFood(Long restaurant_id){
        List<Food> foods = foodRepository.findByRestaurantId(restaurant_id);
        List<FoodDto> foodDtoList = new ArrayList<>();
        for (Food food : foods) {
            foodDtoList.add(new FoodDto(food.getId(), food.getName(), food.getPrice()));
        }
        return foodDtoList;
    }
}
