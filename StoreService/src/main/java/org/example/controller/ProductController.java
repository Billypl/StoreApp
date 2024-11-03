package org.example.controller;

import org.example.dto.CreateProductRequest;
import org.example.dto.ProductResponse;
import org.example.dto.ProductsResponse;
import org.example.dto.UpdateProductRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface ProductController {
    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    ProductsResponse getProducts();

    @GetMapping("/products/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    ProductResponse getProduct(@PathVariable UUID uuid);

    @GetMapping("/categories/{uuid}/products")
    @ResponseStatus(HttpStatus.OK)
    ProductsResponse getProductsByCategory(@PathVariable UUID uuid);

    @PostMapping("/categories/{uuid}/products")
    @ResponseStatus(HttpStatus.CREATED)
    ProductResponse createProduct(@PathVariable UUID uuid, @RequestBody CreateProductRequest request);

    @PatchMapping("/products/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    ProductResponse updateProduct(@PathVariable UUID uuid, @RequestBody UpdateProductRequest request);

    @DeleteMapping("/products/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteProduct(@PathVariable UUID uuid);
}
