package org.example.productservice.controller.product.mapper;

import org.example.productservice.controller.product.dto.ProductResponse;
import org.example.productservice.entity.Product;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProductToResponseMapper implements Function<Product, ProductResponse> {
    @Override
    public ProductResponse apply(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock())
                .categoryId(product.getCategory().getId())
                .build();
    }
}
