package com.sparta.w5_spring_homework.model;

import com.sparta.w5_spring_homework.dto.RestaurantDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;

@Table(name = "restaurant")
@Entity // DB 테이블 설정
@Getter // getter 자동 생성
@NoArgsConstructor // 기본생성자 자동생성
@AllArgsConstructor
@SequenceGenerator(
        name = "RESTAURANT_SEQ_GENERATOR",
        sequenceName = "RESTAURANT_SEQ",
        initialValue = 1, allocationSize = 50
)
public class Restaurant {

    // 기본키 설정
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESTAURANT_SEQ_GENERATOR")
    @Column(name = "restaurant_id")
    private Long id;

    // restarant 이름
    @Column(name = "restaurant_name")
    private String name;

    // 최조주문가격
    @Column(name = "min_order_price")
    private Integer minOrderPrice;

    // 배달비
    @Column(name = "delivery_fee")
    private Integer deliveryFee;

    // 양방향 필요시 기재
//    @OneToMany(mappedBy = "restaurant")
//    private List<Food> foods = new ArrayList<>();

    public Restaurant(String name, Integer minOrderPrice, Integer deliveryFee) {
        this.name = name;
        this.minOrderPrice = minOrderPrice;
        this.deliveryFee = deliveryFee;
    }
}
