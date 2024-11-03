package org.example.mapper;

import org.example.dto.CreateProductRequest;
import org.example.entity.Product;
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
