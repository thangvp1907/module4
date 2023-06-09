package com.codegym.Repository;

import com.codegym.Entity.Category;

import java.util.List;

public interface iRepositoryCategory {
    boolean create(Category category);
    boolean update(Category category);
    Category findById(int id);
    List<Category> findAll();
    boolean deleteById(int id);
}
