package org.example.productservice.controller.product.mapper;

import org.example.productservice.controller.product.dto.CreateProductRequest;
import org.example.productservice.entity.Product;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CreateRequestToProductMapper implements Function<CreateProductRequest, Product> {
    @Override
    public Product apply(CreateProductRequest createProductRequest) {
        return Product.builder()
                .name(createProductRequest.getName())
                .price(createProductRequest.getPrice())
                .stock(createProductRequest.getStock())
                .build();
    }
}
