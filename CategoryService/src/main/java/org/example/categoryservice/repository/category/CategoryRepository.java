package org.example.categoryservice.repository.category;

import org.example.categoryservice.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
    List<Category> findAll();

    Optional<Category> findById(UUID id);

    List<Category> findByNameIgnoreCase(String name);
}
