package com.myshop.domain;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private BigDecimal taxRate;

    protected Product() {
    }

    private Product(Long id, String name, BigDecimal price, BigDecimal taxRate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.taxRate = taxRate;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String name;
        private BigDecimal price;
        private BigDecimal taxRate;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder taxRate(BigDecimal taxRate) {
            this.taxRate = taxRate;
            return this;
        }

        public Product build() {
            // VALIDIERUNGEN hier im Builder
            if (id == null || id <= 0) {
                throw new IllegalArgumentException("ID must be positive and not null");
            }
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name must not be empty");
            }
            if (price == null || price.compareTo(BigDecimal.ZERO) < 0) {
                throw new IllegalArgumentException("Price must be zero or positive");
            }
            if (taxRate == null || taxRate.compareTo(BigDecimal.ZERO) < 0
                    || taxRate.compareTo(BigDecimal.ONE) > 0) {
                throw new IllegalArgumentException("Tax rate must be between 0 and 1");
            }
            return new Product(id, name, price, taxRate);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return id != null && id.equals(product.getId());
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", taxRate=" + taxRate +
                '}';
    }
}
