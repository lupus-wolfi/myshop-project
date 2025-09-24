package com.myshop.service;

import com.myshop.domain.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductService {

    private final List<Product> products = new ArrayList<>();

    public void addProduct(Long id, String name, BigDecimal price, BigDecimal taxRate) {
        try {
            Product product = Product.builder()
                    .id(id)
                    .name(name)
                    .price(price)
                    .taxRate(taxRate)
                    .build(); // Validierung
            products.add(product);
            System.out.println("Product added successfully: " + product);
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }

    public boolean removeProduct(Long id) {
        boolean removed = products.removeIf(p -> p.getId().equals(id));
        return removed;
    }

    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public boolean updateProduct(Long id, String name, BigDecimal price, BigDecimal taxRate) {
        Optional<Product> optionalProduct = findById(id);
        if (optionalProduct.isPresent()) {
            try {
                Product updatedProduct = Product.builder()
                        .id(id)
                        .name(name)
                        .price(price)
                        .taxRate(taxRate)
                        .build(); // Validierung
                Product p = optionalProduct.get();
                p.setName(updatedProduct.getName());
                p.setPrice(updatedProduct.getPrice());
                p.setTaxRate(updatedProduct.getTaxRate());
                return true;
            } catch (IllegalArgumentException e) {
                System.out.println("Error updating product: " + e.getMessage());
            }
        }
        return false;
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
}
