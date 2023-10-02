package com.example.productservice.services;

import com.example.productservice.dtos.GenericProductDto;

public interface ProductService {
    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto getProductById(Long id);
}
