package com.starbuy.ecommerce.services;

import com.starbuy.ecommerce.dto.ProductDTO;
import com.starbuy.ecommerce.dto.ProductRequestDTO;
import com.starbuy.ecommerce.models.Product;
import com.starbuy.ecommerce.repositories.ProductRepository;
import com.starbuy.ecommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.PropertyEditorSupport;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ProductDTO createProduct(ProductRequestDTO dto){
        Product product = new Product();
        copyDtoToEntity(dto, product);
        product = repository.save(product);

        return new ProductDTO(product);
    }

    @Transactional(readOnly = true)
    public ProductDTO findById (Long id){
        Product result = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));
        return new ProductDTO(result);
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll (Pageable pageable){
        Page<Product> result = repository.findAll(pageable);
        return result.map(x -> new ProductDTO(x));
    }

    @Transactional
    public ProductDTO updateProduct(Long id, ProductRequestDTO dto){
        Product product = repository.getReferenceById(id);
        copyDtoToEntity(dto, product);
        product = repository.save(product);
        return new ProductDTO(product);
    }

    @Transactional
    public void deleteById(Long id){
        repository.deleteById(id);
    }

    private void copyDtoToEntity(ProductRequestDTO dto, Product product) {
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setImgUrl(dto.getImgUrl());
    }
}
