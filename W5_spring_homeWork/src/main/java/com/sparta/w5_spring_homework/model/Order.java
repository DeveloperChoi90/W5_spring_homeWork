package com.sparta.w5_spring_homework.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Order {

    @Id     // 기본키 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "order_total_price", nullable = false)
    private Integer totalPrice;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @JsonBackReference
    @OneToMany(mappedBy = "food")
    private List<OrderFood> foods = new ArrayList<>();


    @Builder
    public Order(Restaurant restaurant, List<OrderFood> foods, Integer totalPrice){
        this.restaurant = restaurant;
        this.foods = foods;
        this.totalPrice = totalPrice;
    }
}
