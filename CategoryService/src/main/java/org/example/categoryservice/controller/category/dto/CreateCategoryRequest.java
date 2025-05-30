package org.example.categoryservice.controller.category.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateCategoryRequest {
    String name;
    String description;
    int popularity;
}
