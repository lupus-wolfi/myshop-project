package com.myshop.service;

import com.myshop.domain.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductService {

    // List to store all products
    private final List<Product> products = new ArrayList<>();

    // Adds a product using the builder
    public void addProduct(Long id, String name, BigDecimal price, BigDecimal taxRate) {
        if (findById(id).isPresent()) {
            System.out.println("Error: A product with ID " + id + " alredy exists.");
            return;
        }
        try {
            Product product = Product.builder()
                    .id(id)
                    .name(name)
                    .price(price)
                    .taxRate(taxRate)
                    .build();
            products.add(product);
            System.out.println("Product added successfully: " + product);
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }

    // Removes a product by ID
    public boolean removeProduct(Long id) {
        return products.removeIf(p -> p.getId().equals(id));
    }

    // Finds a product by ID
    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    // Updates an existing product by ID
    public boolean updateProduct(Long id, String name, BigDecimal price, BigDecimal taxRate) {
        Optional<Product> optionalProduct = findById(id);
        if (optionalProduct.isEmpty()) {
            System.out.println("Error: Product with ID " + id + " does not exist.");
            return false;
        }
        try {
            Product updatedProduct = Product.builder()
                    .id(id)
                    .name(name)
                    .price(price)
                    .taxRate(taxRate)
                    .build();

            // Update existing fields
            Product p = optionalProduct.get();
            p.setName(updatedProduct.getName());
            p.setPrice(updatedProduct.getPrice());
            p.setTaxRate(updatedProduct.getTaxRate());
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Error updating product: " + e.getMessage());
            return false;
        }
    }

    // Returns a copy of all products
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
}
