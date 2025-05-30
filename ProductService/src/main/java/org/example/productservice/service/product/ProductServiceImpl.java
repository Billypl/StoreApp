package org.example.productservice.service.product;

import org.example.productservice.entity.Category;
import org.example.productservice.entity.Product;
import org.example.productservice.repository.product.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getById(UUID id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> getByName(String name) {
        return productRepository.findByNameIgnoreCase(name);
    }

    @Override
    public List<Product> getByNameAndCategory(String name, Category category) {
        return productRepository.findByNameIgnoreCaseAndCategory(name, category);
    }

    @Override
    public void create(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(UUID id) {
        productRepository.findById(id).ifPresent(productRepository::delete);
    }
}
