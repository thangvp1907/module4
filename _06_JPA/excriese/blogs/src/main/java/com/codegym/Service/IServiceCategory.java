package com.codegym.Service;

import com.codegym.Entity.Blog;
import com.codegym.Entity.Category;

import java.util.List;
import java.util.Set;

public interface IServiceCategory {

    boolean create(Category category);

    boolean update(Category category);

    boolean deleteById(int id);

    Category findById(int id);

    List<Category> findAll();
}
