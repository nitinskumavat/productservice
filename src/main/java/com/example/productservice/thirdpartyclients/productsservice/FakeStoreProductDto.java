package com.example.productservice.thirdpartyclients.productsservice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private long id;
    private String title;
    private String description;
    private double price;
    private String category;
    private String image;
}