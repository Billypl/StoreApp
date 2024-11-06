package org.example.productservice.repository.product;

import org.example.productservice.entity.Category;
import org.example.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findAll();

    Optional<Product> findById(UUID id);

    List<Product> findByCategory(Category category);

    List<Product> findByNameIgnoreCase(String name);

    List<Product> findByNameIgnoreCaseAndCategory(String name, Category category);
}
