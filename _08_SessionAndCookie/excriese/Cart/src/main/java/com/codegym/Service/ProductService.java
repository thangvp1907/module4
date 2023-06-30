package com.codegym.Service;

import com.codegym.Entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    Optional<Product> findById(Integer id);
}
