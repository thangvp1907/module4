package com.codegym.Service;

import com.codegym.Entity.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();

    Category findById(Integer id);
}
