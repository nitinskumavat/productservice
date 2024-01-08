package com.example.productservice.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDto {
    private String id;
    @NotBlank(message = "Product Title is required.")
    private String title;
    private String description;
    private double price;
    @NotBlank(message = "Product Category is required.")
    private String category;
    private String image;
}
