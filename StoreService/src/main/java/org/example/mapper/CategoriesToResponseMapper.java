package org.example.mapper;

import org.example.dto.CategoriesResponse;
import org.example.entity.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class CategoriesToResponseMapper implements Function<List<Category>, CategoriesResponse> {
    @Override
    public CategoriesResponse apply(List<Category> categories) {
        return CategoriesResponse.builder()
                .categories(categories.stream()
                        .map(category -> CategoriesResponse.Category.builder()
                                .id(category.getId())
                                .name(category.getName())
                                .build())
                        .toList())
                .build();

    }
}
