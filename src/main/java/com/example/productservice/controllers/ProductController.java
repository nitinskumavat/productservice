package com.example.productservice.controllers;

import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.services.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService=productService;
    }

    @GetMapping("")
    public String getAllProducts() {
        return ("All products");
    }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") long id) {
        return productService.getProductById(id);
    }


    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product) {
        return productService.createProduct(product);
    }

    public void updateProductById() {
    }
}
