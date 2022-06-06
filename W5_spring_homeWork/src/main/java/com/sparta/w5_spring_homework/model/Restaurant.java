package com.sparta.w5_spring_homework.model;

import com.sparta.w5_spring_homework.dto.RestaurantDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;

@Table(name = "restaurant")
@Entity // DB 테이블 설정
@Getter // getter 자동 생성
@NoArgsConstructor // 기본생성자 자동생성
public class Restaurant {

    // 기본키 설정
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long id;

    // restarant 이름
    @Column(name = "restaurant_name")
    private String name;

    // 최조주문가격
    @Column(name = "min_order_price", nullable = false)
    private Integer minOrderPrice;

    // 배달비
    @Column(name = "delivery_fee", nullable = false)
    private Integer deliveryFee;


//    @OneToMany(mappedBy = "restaurant")
//    private List<Food> foods = new ArrayList<>();

    public Restaurant(RestaurantDto restaurantDto) {
        this.name = restaurantDto.getName();
        this.minOrderPrice = restaurantDto.getMinOrderPrice();
        this.deliveryFee = restaurantDto.getDeliveryFee();
    }
}
