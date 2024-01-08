package com.example.productservice.services;

import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.exceptions.NotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Price;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Service
public class SelfProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    SelfProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    private GenericProductDto convertProductToGenericProductDto(Product product) {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setCategory(product.getCategory().getName());
        genericProductDto.setTitle(product.getTitle());
        genericProductDto.setDescription(product.getDescription());
        genericProductDto.setImage(product.getImage());
        genericProductDto.setPrice(product.getPrice().getPrice());
        genericProductDto.setId(product.getId().toString());

        return genericProductDto;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto productDto) {
        Product product = new Product();
        Price price = new Price("Rupee", productDto.getPrice());
        Category category;
        if (categoryRepository.existsByName(productDto.getCategory())) {
            category = categoryRepository.findByName(productDto.getCategory()).get();
        } else {
            category = new Category();
            category.setName(productDto.getCategory());
        }
        product.setPrice(price);
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setImage(productDto.getImage());
        product.setCategory(category);
        productRepository.save(product);
        return convertProductToGenericProductDto(product);
    }

    @Override
    public GenericProductDto getProductById(String id) throws NotFoundException {
        Optional<Product> product = productRepository.findById(UUID.fromString(id));
        if (product.isEmpty()) {
            throw new NotFoundException("Product not Found");
        }
        return convertProductToGenericProductDto(product.get());
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for (Product product : products) {
            genericProductDtos.add(convertProductToGenericProductDto(product));
        }
        return genericProductDtos;
    }

    @Override
    public GenericProductDto deleteProduct(String id) {
        productRepository.deleteById(UUID.fromString(id));
        return null;
    }

    @Override
    public GenericProductDto updateProduct(String id, GenericProductDto productDto) {
        return null;
    }
}
