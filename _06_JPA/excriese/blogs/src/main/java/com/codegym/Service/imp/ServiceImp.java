package com.codegym.Service.imp;

import com.codegym.Entity.Blog;
import com.codegym.Repository.IRepository;
import com.codegym.Service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImp implements IService {
    private final IRepository repository;


    public ServiceImp(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean create(Blog blog) {
        repository.save(blog);
        return true;
    }

    @Override
    public boolean update(Blog blog) {
        if(repository.existsById(blog.getId())){
            repository.save(blog);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        if(repository.existsById(id)){
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
}
