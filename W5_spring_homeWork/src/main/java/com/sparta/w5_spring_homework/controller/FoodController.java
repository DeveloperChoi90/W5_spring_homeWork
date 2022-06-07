package com.sparta.w5_spring_homework.controller;


import com.sparta.w5_spring_homework.dto.FoodDto;
import com.sparta.w5_spring_homework.model.Food;
import com.sparta.w5_spring_homework.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FoodController {


    private final FoodService foodService;

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void registerFood(@PathVariable Long restaurantId, @RequestBody List<FoodDto> foodDtoList){
        foodService.registerFood(restaurantId, foodDtoList);
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<FoodDto> searchFood(@PathVariable Long restaurantId){
        return foodService.searchFood(restaurantId);
    }
}
