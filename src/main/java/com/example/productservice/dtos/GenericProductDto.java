package com.example.productservice.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDto {
    private String id;
    @NotBlank(message = "Product title is required.")
    private String title;
    private String description;
    @Positive(message = "Price must be a positive value.")
    @NotNull(message = "Product price is required.")
    private double price;
    @NotBlank(message = "Product category is required.")
    private String category;
    private String image;
}
