package com.example.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDto {
    private long id;
    private String title;
    private String description;
    private double price;
    private String category;
    private String image;
}
