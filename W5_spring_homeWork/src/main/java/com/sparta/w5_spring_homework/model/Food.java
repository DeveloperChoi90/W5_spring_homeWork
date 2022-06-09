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
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
        name = "FOOD_SEQ_GENERATOR",
        sequenceName = "FOOD_SEQ",
        initialValue = 1, allocationSize = 50
)
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FOOD_SEQ_GENERATOR")
    @Column(name = "food_id")
    private Long id;

    @Column(name = "food_name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;


    @OneToMany(mappedBy = "food")
    private List<OrderFood> foods = new ArrayList<>();

    @Builder
    public Food(Restaurant restaurant, String name, Integer price){
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
    }
}
