package com.sparta.w5_spring_homework.controller;

import com.sparta.w5_spring_homework.dto.RestaurantDto;
import com.sparta.w5_spring_homework.model.Restaurant;
import com.sparta.w5_spring_homework.repository.FoodRepository;
import com.sparta.w5_spring_homework.repository.RestaurantRepository;
import com.sparta.w5_spring_homework.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;

    private final RestaurantService restaurantService;

    @PostMapping("/restaurant/register")
    public String registerRestaurant(@RequestBody RestaurantDto restaurantDto ){
        return restaurantService.registerRestaurant(restaurantDto);
    }

    @GetMapping("/restaurants")
    public List<Restaurant> searchRestaurant(){
        return restaurantRepository.findAll();
    }
}
