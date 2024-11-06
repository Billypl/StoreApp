package org.example.productservice.service.product;

import org.example.productservice.entity.Category;
import org.example.productservice.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    List<Product> getAll();

    Optional<Product> getById(UUID id);

    List<Product> getByCategory(Category category);

    List<Product> getByName(String name);

    List<Product> getByNameAndCategory(String name, Category category);

    void create(Product product);

    void update(Product product);

    void delete(UUID id);
}
