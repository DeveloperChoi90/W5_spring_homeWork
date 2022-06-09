package com.sparta.w5_spring_homework.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "ORDERFOOD")
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
        name = "ORDERFOOD_SEQ_GENERATOR",
        sequenceName = "ORDERFOOD_SEQ",
        initialValue = 1, allocationSize = 50
)
public class OrderFood {

    @Id // 기본키 설정
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDERFOOD_SEQ_GENERATOR")
    private Long id; // order_food id

    @JsonBackReference
    @ManyToOne  // 주문과 음식의 다대다 관계를 풀기위해 다대일 관계로 품
    @JoinColumn(name = "order_id")
    private Order order;

    @JsonBackReference
    @ManyToOne  // 주문과 음식의 다대다 관계를 풀기위해 다대일 관계로 품
    @JoinColumn(name = "food_id")
    private Food food;

    @Column(name = "quantity")
    private Integer quantity;   // 주문 수량

    @Column(name = "food_total_price")
    private Integer price;  // 주문한 음식의 총 가격

    public OrderFood(Order order, Food food, Integer quantity){
        this.order = order;
        this.food = food;
        this.quantity = quantity;
        this.price = food.getPrice() * quantity;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
