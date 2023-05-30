package com.codegym.service;

import com.codegym.model.Category;

import java.util.List;

public interface iCategory {
     boolean create(Category category);
    boolean update(Category category);
    Category findById(int id);
    List<Category> findAll();
    boolean deleteById(int id);
}
