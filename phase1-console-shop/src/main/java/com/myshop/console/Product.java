package com.myshop.console;

import java.math.BigDecimal;

public class Product {

    // Week 1: Define product attributes (id, name, price, taxRate)
    // Add constructor and getters
    private long id;
    private String name;
    private BigDecimal price;
    private  BigDecimal taxRate;

    public Product(long id, String name, BigDecimal price,BigDecimal taxRate){
        this.id = id;
        this.name = name;
        this.price = price;
        this.taxRate = taxRate;
    }

    public long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public BigDecimal getTaxRate(){
        return taxRate;
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
