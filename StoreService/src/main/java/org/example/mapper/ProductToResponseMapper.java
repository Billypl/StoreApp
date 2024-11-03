package org.example.mapper;

import org.example.dto.ProductResponse;
import org.example.entity.Product;
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
                .category(ProductResponse.Category.builder()
                        .id(product.getCategory().getId())
                        .name(product.getCategory().getName())
                        .build())
                .build();
    }
}
