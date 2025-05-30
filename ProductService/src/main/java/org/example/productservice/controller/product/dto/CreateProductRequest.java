package org.example.productservice.controller.product.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateProductRequest {
    String name;
    int price;
    int stock;
}
