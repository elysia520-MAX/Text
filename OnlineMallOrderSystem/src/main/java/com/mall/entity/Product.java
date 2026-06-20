package com.mall.entity;

import java.math.BigDecimal;

/**
 * 商品实体类
 * 对应数据库中的product表
 */
public class Product {
    private Integer productId;
    private String productName;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private String category;
    private Long createdTime;

    public Product() {}

    public Product(String productName, String description, BigDecimal price, Integer stock, String category) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    // Getters and Setters
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", category='" + category + '\'' +
                '}';
    }
}
