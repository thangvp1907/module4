package com.codegym.Service.imp;

import com.codegym.Entity.Blog;
import com.codegym.Repository.IBlogRepo;
import com.codegym.Service.IServiceBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceBlogImpBlog implements IServiceBlog {
    public  final IBlogRepo repository;

    public ServiceBlogImpBlog(IBlogRepo repository) {
        this.repository = repository;
    }

    @Override
    public boolean create(Blog blog) {
        repository.save(blog);
        return true;
    }

    @Override
    public boolean update(Blog blog) {
        if (repository.existsById(blog.getId())) {
            repository.save(blog);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;

        }
        return false;
    }

    @Override
    public Blog findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findAll() {
        return (List<Blog>) repository.findAll();
    }

    @Override
    public Page<Blog> findAllPage(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
