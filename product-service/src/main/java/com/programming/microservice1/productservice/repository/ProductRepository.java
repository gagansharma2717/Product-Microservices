package com.programming.microservice1.productservice.repository;

import com.programming.microservice1.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductRepository extends MongoRepository<Product, String> {
}
