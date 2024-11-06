package org.example.categoryservice.controller.category.mapper;

import org.example.categoryservice.controller.category.dto.CategoryResponse;
import org.example.categoryservice.entity.Category;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CategoryToResponseMapper implements Function<Category, CategoryResponse> {
    @Override
    public CategoryResponse apply(Category category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .popularity(category.getPopularity())
                .build();
    }
}
