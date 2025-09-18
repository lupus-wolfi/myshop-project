package com.myshop.console;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    // Product attributes
    private Long id;
    private String name;
    private BigDecimal price;
    private BigDecimal taxRate;

    // Empty constructor for frameworks
    protected Product(){}

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

    // Private constructor used only by the Builder
    private Product(Long id, String name, BigDecimal price, BigDecimal taxRate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.taxRate = taxRate;
    }

    // Factory method to initiate the Builder
    public static Builder builder() {
        return new Builder();
    }

    // Static inner Builder class
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
            return new Product(id, name, price, taxRate);
        }
    }

    // Getter methods
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

    // Setter methods
    public void setId(Long id){
        this.id =id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }
    public void setTaxRate(BigDecimal taxRate){
        this.taxRate = taxRate;
    }

    // toString() method for text representation
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
