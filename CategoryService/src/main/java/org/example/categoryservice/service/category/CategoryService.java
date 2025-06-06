package org.example.categoryservice.service.category;

import org.example.categoryservice.entity.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {
    List<Category> getAll();

    Optional<Category> getById(UUID id);

    List<Category> getByName(String name);

    void create(Category category);

    void update(Category category);

    void delete(UUID id);
}
