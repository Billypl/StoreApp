package org.example.productservice.service.category;

import org.example.productservice.entity.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {
    List<Category> getAll();

    Optional<Category> getById(UUID id);

    void create(Category category);

    void delete(UUID id);
}
