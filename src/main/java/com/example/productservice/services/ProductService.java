package com.example.productservice.services;

import com.example.productservice.dtos.GenericProductDto;

import java.util.List;

public interface ProductService {
    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto getProductById(Long id);

    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProduct(Long id);

    GenericProductDto updateProduct(Long id,GenericProductDto productDto);
}
