package com.programming.microservice1.productservice.controller;

import com.programming.microservice1.productservice.model.Product;
import com.programming.microservice1.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAll()
    {
        return productRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void createProduct(@RequestBody Product product){
        productRepository.save(product);
    }
}
