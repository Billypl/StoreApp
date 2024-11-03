package org.example.service;

import org.example.entity.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {
    List<Category> findAll();

    Optional<Category> findById(UUID id);

    List<Category> findByName(String name);

    void create(Category category);

    void update(Category category);

    void delete(UUID id);
}
