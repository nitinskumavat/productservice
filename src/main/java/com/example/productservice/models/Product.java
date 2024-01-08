package com.example.productservice.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends BaseModel {
    private String title;
    private String description;
    private String image;
    // P : C
    // => L to R: 1 : 1
    // => R to L: m : 1
    // => Ans: m : 1
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "category")
    private Category category;
    //    private double price;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Price price;

}