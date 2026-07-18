package com.firstspringproject.store.controllers;

import java.net.URI;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.firstspringproject.store.dto.ProductDto;
import com.firstspringproject.store.entities.Product;
import com.firstspringproject.store.mappers.ProductMapper;
import com.firstspringproject.store.repositories.ProductRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

import com.firstspringproject.store.repositories.CategoryRepository;
import com.firstspringproject.store.entities.Category;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/products")
@AllArgsConstructor
@RestController
@Tag(name = "Products")
public class ProductController {
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    private ProductMapper productMapper;

    @GetMapping
    public List<ProductDto> getAllProducts(
            @RequestParam(required = false, name = "categoryId") Byte categoryId) {

        List<Product> products;

        if (categoryId != null) {
            products = productRepository.findProductsByCategoryId(categoryId);
        } else {
            products = productRepository.findAll();
        }

        return products.stream().map(productMapper::toDto).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ProductDto>> getProduct(@PathVariable Long id) {
        List<Product> products = productRepository.findProductById(id);

        if (products != null && !products.isEmpty()) {
            return ResponseEntity.ok(products.stream().map(productMapper::toDto).toList());
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(
            @RequestBody ProductDto productDto,
            UriComponentsBuilder uriBuilder) {
        var category = categoryRepository.findById(productDto.getCategoryid()).orElse(null);
        if (category == null) {
            return ResponseEntity.badRequest().build();
        }
        var product = productMapper.toEntity(productDto);

        product.setCategory(category);
        productRepository.save(product);

        productDto.setId(product.getId());
        var uri = uriBuilder.path("/products/{id}").buildAndExpand(productDto.getId()).toUri();
        return ResponseEntity.created(uri).body(productDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductDto request) {
        var category = categoryRepository.findById(request.getCategoryid()).orElse(null);
        if (category == null) {
            return ResponseEntity.badRequest().build();
        }
        var product = productRepository.findById(id).orElse(null);

        if (product == null) {
            return ResponseEntity.notFound().build();
        }

        productMapper.update(request, product);
        product.setCategory(category);

        productRepository.save(product);

        return ResponseEntity.ok(productMapper.toDto(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(
        @PathVariable Long id
    ){
        var product = productRepository.findById(id).orElse(null);

        if (product == null) {
            return ResponseEntity.notFound().build();
        }

        productRepository.delete(product);

        return ResponseEntity.noContent().build();
    }
}
