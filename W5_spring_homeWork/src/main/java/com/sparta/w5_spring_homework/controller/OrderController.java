package com.sparta.w5_spring_homework.controller;


import com.sparta.w5_spring_homework.dto.OrderDto;
import com.sparta.w5_spring_homework.dto.OrderRequestDto;
import com.sparta.w5_spring_homework.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order/request")
    public OrderDto requestOrder(@RequestBody OrderRequestDto orderRequestDto){
//        log.info("request = {}", orderRequestDto);
        return orderService.requestOrder(orderRequestDto);
    }

    @GetMapping("/orders")
    public List<OrderDto> searchOrders(){
        return orderService.searchOrders();
    }

}
