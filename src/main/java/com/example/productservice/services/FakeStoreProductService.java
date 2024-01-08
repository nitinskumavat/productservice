package com.example.productservice.services;

import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.exceptions.NotFoundException;
import com.example.productservice.thirdpartyclients.productsservice.FakeStoreProductDto;
import com.example.productservice.thirdpartyclients.productsservice.FakeStoreProductServiceClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private final FakeStoreProductServiceClient fakeStoreProductServiceClient;

    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient) {
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }

    private GenericProductDto convertFakeStoreProductIntoGenericProduct(FakeStoreProductDto fakeStoreProductDto) {
        GenericProductDto product = new GenericProductDto();
        product.setId(Long.toString(fakeStoreProductDto.getId()));
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());
        return product;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.createProduct(product));
    }

    @Override
    public GenericProductDto getProductById(String id) throws NotFoundException {
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.getProductById(Long.parseLong(id)));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<GenericProductDto> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductServiceClient.getAllProducts()) {
            products.add(convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto));
        }
        return products;
    }

    @Override
    public GenericProductDto deleteProduct(String id) throws NotFoundException {
        Long productId = Long.parseLong(id);
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.deleteProduct(productId));
    }

    @Override
    public GenericProductDto updateProduct(String id, GenericProductDto product) throws NotFoundException {
        Long productId = Long.parseLong(id);
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.updateProduct(productId, product));
    }


}
