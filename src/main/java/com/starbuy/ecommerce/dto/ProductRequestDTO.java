package com.starbuy.ecommerce.dto;

import com.starbuy.ecommerce.models.Product;

public class ProductRequestDTO {

    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    public ProductRequestDTO() {
    }

    public ProductRequestDTO(String name, String description, Double price, String imgUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductRequestDTO(Product entity) {
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        imgUrl = entity.getImgUrl();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
