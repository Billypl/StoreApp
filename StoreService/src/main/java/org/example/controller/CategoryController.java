package org.example.controller;

import org.example.dto.CategoriesResponse;
import org.example.dto.CategoryResponse;
import org.example.dto.CreateCategoryRequest;
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
