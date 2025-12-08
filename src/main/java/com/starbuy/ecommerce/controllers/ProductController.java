package com.starbuy.ecommerce.controllers;

import com.starbuy.ecommerce.dto.ProductDTO;
import com.starbuy.ecommerce.models.Product;
import com.starbuy.ecommerce.repositories.ProductRepository;
import com.starbuy.ecommerce.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public Page<ProductDTO> products (Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ProductDTO product (@PathVariable Long id) {
        return service.findById(id);
    }

}
