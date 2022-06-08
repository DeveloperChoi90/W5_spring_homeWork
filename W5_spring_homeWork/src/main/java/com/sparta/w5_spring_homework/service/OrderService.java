package com.sparta.w5_spring_homework.service;


import com.sparta.w5_spring_homework.dto.*;
import com.sparta.w5_spring_homework.model.Food;
import com.sparta.w5_spring_homework.model.Order;
import com.sparta.w5_spring_homework.model.OrderFood;
import com.sparta.w5_spring_homework.model.Restaurant;
import com.sparta.w5_spring_homework.repository.FoodRepository;
import com.sparta.w5_spring_homework.repository.OrderFoodRepository;
import com.sparta.w5_spring_homework.repository.OrderRepository;
import com.sparta.w5_spring_homework.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class OrderService {

    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;
    private final OrderFoodRepository orderFoodRepository;
    private final OrderRepository orderRepository;


    @Transactional
    public OrderDto requestOrder(OrderRequestDto orderRequestDto) {

        // OrderDto => Order Response
        Restaurant restaurant = restaurantRepository.findById(orderRequestDto.getRestaurantId()).orElseThrow(
                () -> new IllegalArgumentException("음식점이 등록되어 있지 않습니다."));

        List<OrderFoodDto> orderFoodDtoList = new ArrayList<>(); // response list
        List<OrderFood> orderFoodList = new ArrayList<>(); // DB 저장 list

        // TODO: 2022/06/08
        // order 를 영속성 컨텍스트에 order를 저장하여 테이블에 반영
        Order order = new Order();
        orderRepository.save(order);

        int totalPrice = 0;

        for (OrderFoodRequestDto orderFoodRequestDto : orderRequestDto.getFoods()) {
            Food food = foodRepository.findByIdAndRestaurant(orderFoodRequestDto.getId(), restaurant).orElseThrow(
                    ()-> new IllegalArgumentException("주문하신 음식은 등록되어 있지 않습니다."));

            if(orderFoodRequestDto.getQuantity() < 1 || orderFoodRequestDto.getQuantity() > 100){
                throw new IllegalArgumentException("주문한 음식의 수량을 확인해 주세요. 1 ~ 100개 까지만 주문이 가능합니다.");
            }

            // OrderFood entity 저장
            OrderFood orderFood = new OrderFood(food, orderFoodRequestDto.getQuantity());
            order.addOrderFood(orderFood);
            orderFoodList.add(orderFood);
            orderFoodRepository.save(orderFood);
            orderRepository.save(order);

            OrderFoodDto orderFoodDto = new OrderFoodDto(food, orderFoodRequestDto);
            orderFoodDtoList.add(orderFoodDto);

            // 주문한 음식의 전체 금액 계산
            totalPrice += (food.getPrice() * orderFoodRequestDto.getQuantity());
        }

        if(totalPrice < restaurant.getMinOrderPrice()) throw new IllegalArgumentException("최소 주문 가격보다 적은 금액입니다.");

        // TODO: 2022/06/08
        order.setRestaurant(restaurant);
        order.setFoods(orderFoodList);
        order.setTotalPrice(totalPrice);
        orderRepository.save(order);

        return new OrderDto(restaurant, orderFoodDtoList, totalPrice);
    }


    @Transactional(readOnly = true)
    public List<OrderDto> searchOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDto> orderDtoList = new ArrayList<>();

        for (Order order : orders) {
            List<OrderFoodDto> orderFoodDtoList = new ArrayList<>();
//            System.out.println(order.getFoods());
            for(OrderFood orderFood : order.getFoods()){ // foods = order.getFoods() // List<OrderFood>
                Food food = orderFood.getFood();
//                Order order1 = orderFood.getOrder();
                OrderFoodDto orderFoodDto = new OrderFoodDto(food, orderFood.getQuantity());
                orderFoodDtoList.add(orderFoodDto);
            }

            Restaurant restaurant = order.getRestaurant();
            OrderDto orderDto = new OrderDto(restaurant.getName(), orderFoodDtoList, restaurant.getDeliveryFee(), order.getTotalPrice());
            orderDtoList.add(orderDto);
        }
        return orderDtoList;
    }
}
