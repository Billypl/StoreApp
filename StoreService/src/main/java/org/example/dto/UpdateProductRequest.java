package org.example.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UpdateProductRequest {
    String name;
    Integer price;
    Integer stock;
}
