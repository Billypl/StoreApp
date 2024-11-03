package org.example.mapper;

import org.example.dto.CreateCategoryRequest;
import org.example.entity.Category;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CreateRequestToCategoryMapper implements Function<CreateCategoryRequest, Category> {
    @Override
    public Category apply(CreateCategoryRequest createCategoryRequest) {
        return Category.builder()
                .name(createCategoryRequest.getName())
                .description(createCategoryRequest.getDescription())
                .popularity(createCategoryRequest.getPopularity())
                .build();
    }
}
