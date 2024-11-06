package org.example.categoryservice.controller.category;

import org.example.categoryservice.controller.category.dto.CategoriesResponse;
import org.example.categoryservice.controller.category.dto.CategoryResponse;
import org.example.categoryservice.controller.category.dto.CreateCategoryRequest;
import org.example.categoryservice.controller.category.dto.UpdateCategoryRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface CategoryController {
    @GetMapping("/categories")
    @ResponseStatus(HttpStatus.OK)
    CategoriesResponse getCategories();

    @GetMapping("/categories/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    CategoryResponse getCategory(@PathVariable UUID uuid);

    @PutMapping("/categories")
    @ResponseStatus(HttpStatus.CREATED)
    CategoryResponse createCategory(@RequestBody CreateCategoryRequest request);

    @PatchMapping("/categories/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    CategoryResponse updateCategory(@PathVariable UUID uuid, @RequestBody UpdateCategoryRequest request);

    @DeleteMapping("/categories/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCategory(@PathVariable UUID uuid);
}
