package com.sparta.w5_spring_homework.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
        name = "ORDER_SEQ_GENERATOR",
        sequenceName = "ORDER_SEQ",
        initialValue = 1, allocationSize = 50
)
public class Order {

    @Id     // 기본키 설정
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ_GENERATOR")
    @Column(name = "order_id")
    private Long id;

    @Column(name = "order_total_price")
    private Integer totalPrice;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;


    @OneToMany(mappedBy = "order")
    private List<OrderFood> foods = new ArrayList<>();

    // TODO: 2022/06/08
    // 연관관계 주인에 set을 해야된다.
    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setFoods(List<OrderFood> foods) {
        this.foods = foods;
    }

    @Builder
    public Order(Restaurant restaurant, List<OrderFood> foods, Integer totalPrice){
        this.restaurant = restaurant;
        this.foods = foods;
        this.totalPrice = totalPrice;
    }

    public void setOrder(Restaurant restaurant, List<OrderFood> foods, Integer totalPrice){
        this.restaurant = restaurant;
        this.foods = foods;
        this.totalPrice = totalPrice;
    }

    // 연관 관계 편의 메소드
    public void addOrderFood(OrderFood orderFood){
        foods.add(orderFood);
        orderFood.setOrder(this);
    }
}
