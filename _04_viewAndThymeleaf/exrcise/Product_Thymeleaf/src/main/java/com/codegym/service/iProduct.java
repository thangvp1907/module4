package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface iProduct {
    Product findById(int id);

    List<Product> findAll();

    boolean create(Product product);

    boolean update(Product product);

    boolean delete(int id);

    List<Product> findByName(String name);

    List<Product> findByCate(int cate);

}
