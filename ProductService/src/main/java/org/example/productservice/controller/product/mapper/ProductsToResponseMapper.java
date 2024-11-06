package org.example.productservice.controller.product.mapper;

import org.example.productservice.controller.product.dto.ProductsResponse;
import org.example.productservice.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class ProductsToResponseMapper implements Function<List<Product>, ProductsResponse> {

    @Override
    public ProductsResponse apply(List<Product> products) {
        return ProductsResponse.builder()
                .products(products.stream()
                        .map(product -> ProductsResponse.Product.builder()
                                .id(product.getId())
                                .name(product.getName())
                                .build())
                        .toList())
                .build();
    }
}
