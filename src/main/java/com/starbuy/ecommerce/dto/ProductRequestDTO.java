package com.starbuy.ecommerce.dto;

import com.starbuy.ecommerce.models.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductRequestDTO {

    @Size(min = 3, max = 80, message = "The name must be between 3 and 80 characters long")
    @NotBlank(message = "The name cannot be blank")
    private String name;
    @Size(min = 10, message = "The description must be at least 10 characters long")
    @NotBlank
    private String description;
    @Positive(message = "The price should be positive")
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
