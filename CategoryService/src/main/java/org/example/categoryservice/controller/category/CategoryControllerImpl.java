package org.example.categoryservice.controller.category;

import org.example.categoryservice.controller.category.dto.CategoriesResponse;
import org.example.categoryservice.controller.category.dto.CategoryResponse;
import org.example.categoryservice.controller.category.dto.CreateCategoryRequest;
import org.example.categoryservice.controller.category.dto.UpdateCategoryRequest;
import org.example.categoryservice.controller.category.mapper.CategoriesToResponseMapper;
import org.example.categoryservice.controller.category.mapper.CategoryToResponseMapper;
import org.example.categoryservice.controller.category.mapper.CreateRequestToCategoryMapper;
import org.example.categoryservice.service.category.CategoryService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class CategoryControllerImpl implements CategoryController {
    private final CategoryService categoryService;

    private final CategoryToResponseMapper categoryToResponseMapper;
    private final CategoriesToResponseMapper categoriesToResponseMapper;
    private final CreateRequestToCategoryMapper createRequestToCategoryMapper;


    public CategoryControllerImpl(CategoryService categoryService,
                                  CategoryToResponseMapper categoryToResponseMapper,
                                  CategoriesToResponseMapper categoriesToResponseMapper,
                                  CreateRequestToCategoryMapper createRequestToCategoryMapper) {
        this.categoryService = categoryService;
        this.categoryToResponseMapper = categoryToResponseMapper;
        this.categoriesToResponseMapper = categoriesToResponseMapper;
        this.createRequestToCategoryMapper = createRequestToCategoryMapper;
    }

    @Override
    public CategoriesResponse getCategories() {
        log.info("Get all categories");

        return categoriesToResponseMapper.apply(categoryService.getAll());
    }

    @Override
    public CategoryResponse getCategory(UUID uuid) {
        log.info("Get category with UUID: " + uuid);

        return categoryService.getById(uuid)
                .map(categoryToResponseMapper)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
    }

    @Override
    public CategoryResponse createCategory(CreateCategoryRequest request) {
        log.info("Create category with name: " + request.getName());

        if (request.getName() == null || request.getName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name is required");
        }
        if (request.getPopularity() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Popularity must be greater than or equal to 0");
        }

        var category = createRequestToCategoryMapper.apply(request);
        categoryService.create(category);

        return categoryToResponseMapper.apply(category);
    }

    @Override
    public CategoryResponse updateCategory(UUID uuid, UpdateCategoryRequest request) {
        log.info("Update category with UUID: " + uuid);

        var category = categoryService.getById(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));

        if (request.getName() != null) {
            if (request.getName().isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name cannot be empty");
            }
            category.setName(request.getName());
        }
        if (request.getDescription() != null) {
            category.setDescription(request.getDescription());
        }
        if (request.getPopularity() != null) {
            if (request.getPopularity() < 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Popularity must be greater than or equal to 0");
            }
            category.setPopularity(request.getPopularity());
        }

        categoryService.update(category);

        return categoryToResponseMapper.apply(category);
    }

    @Override
    public void deleteCategory(UUID uuid) {
        log.info("Delete category with UUID: " + uuid);

        if (categoryService.getById(uuid).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }
        categoryService.delete(uuid);
    }
}
