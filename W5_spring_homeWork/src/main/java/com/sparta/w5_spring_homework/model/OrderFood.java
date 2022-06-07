package com.sparta.w5_spring_homework.model;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "ORDERFOOD")
@NoArgsConstructor
public class OrderFood {

    @Id // 기본키 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // order_food id

    @ManyToOne  // 주문과 음식의 다대다 관계를 풀기위해 다대일 관계로 품
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne  // 주문과 음식의 다대다 관계를 풀기위해 다대일 관계로 품
    @JoinColumn(name = "food_id")
    private Food food;

    @Column(name = "quantity")
    private Integer quantity;   // 주문 수량

    @Column(name = "food_total_price")
    private Integer price;  // 주문한 음식의 총 가격

    public OrderFood(Food food, Integer quantity){
        this.food = food;
//        this.order = order
        this.quantity = quantity;
        this.price = food.getPrice() * quantity;
    }
}
