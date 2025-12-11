package com.starbuy.ecommerce.controllers;

import com.starbuy.ecommerce.dto.ProductDTO;
import com.starbuy.ecommerce.dto.ProductRequestDTO;
import com.starbuy.ecommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity <ProductDTO> newProduct (@RequestBody @Valid ProductRequestDTO dto){
        ProductDTO product = service.createProduct(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(product);
    }

    @GetMapping
    public ResponseEntity <Page<ProductDTO>> findAll (Pageable pageable) {
        Page<ProductDTO> allProducts = service.findAll(pageable);
        return ResponseEntity.ok(allProducts);
    }

    @GetMapping("/{id}")
    public ResponseEntity <ProductDTO> findById (@PathVariable Long id) {
        ProductDTO product = service.findById(id);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity <ProductDTO> update(@PathVariable Long id, @RequestBody @Valid ProductRequestDTO dto){
        ProductDTO updatedProduct = service.updateProduct(id, dto);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete(@PathVariable Long id){
        service.deleteById(id);
        return  ResponseEntity.noContent().build();
    }
}
