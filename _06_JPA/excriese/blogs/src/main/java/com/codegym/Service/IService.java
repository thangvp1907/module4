package com.codegym.Service;

import com.codegym.Entity.Blog;

import java.util.List;

public interface IService {
    boolean create(Blog blog);

    boolean update(Blog blog);

    boolean deleteById(int id);

    Blog findById(int id);

    List<Blog> findAll();

}
