package com.starbuy.ecommerce.controllers;

import com.starbuy.ecommerce.dto.ProductDTO;
import com.starbuy.ecommerce.dto.ProductRequestDTO;
import com.starbuy.ecommerce.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity <ProductDTO> newProduct (@RequestBody ProductRequestDTO dto){
        ProductDTO product = service.createProduct(dto);
        return ResponseEntity.ok(product);
    }

    @GetMapping
    public Page<ProductDTO> findAll (Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ProductDTO findById (@PathVariable Long id) {
        return service.findById(id);
    }

}
