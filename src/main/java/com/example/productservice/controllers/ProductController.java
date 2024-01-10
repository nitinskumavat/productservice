package com.example.productservice.controllers;

import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.exceptions.NotFoundException;
import com.example.productservice.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public List<GenericProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") String id) throws NotFoundException {
        return productService.getProductById(id);
    }


    @PostMapping
    public GenericProductDto createProduct(@Valid @RequestBody GenericProductDto product) {
        return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") String id) throws NotFoundException {
        return new ResponseEntity<>(
                productService.deleteProduct(id),
                HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public GenericProductDto updateProductById(@RequestBody GenericProductDto productDto, @PathVariable("id") String id) throws NotFoundException {
        return productService.updateProduct(id, productDto);
    }
}
