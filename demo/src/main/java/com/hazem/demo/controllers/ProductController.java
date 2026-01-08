package com.hazem.demo.controllers;

import com.hazem.demo.dtos.ProductDto;
import com.hazem.demo.mapper.ProductMapper;
import com.hazem.demo.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @GetMapping
    public Iterable<ProductDto> getAllProducts(
            @RequestParam(required = false, defaultValue = "", name = "categoryId") String categoryId
    ) {
        if (!Set.of("name", "description", "price").contains(sort)) {
            sort = "name";
        }
        return productRepository.findAll(Sort.by(sort)).stream().map(productMapper::toDto).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        var product = productRepository.findById(id).orElse(null);
        if (product == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(productMapper.toDto(product));
    }
}
