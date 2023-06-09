package com.codegym.Service;

import com.codegym.Entity.Product;

import java.util.List;

public interface iServiceProduct {
    Product findById(int id);

    List<Product> findAll();

    boolean create(Product product);

    boolean update(Product product);

    boolean delete(int id);

    List<Product> findByName(String name);

    List<Product> findByCate(int cate);
}
