package com.codegym.Service.imp;

import com.codegym.Entity.Category;
import com.codegym.Repository.iRepositoryCategory;
import com.codegym.Service.iServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class serviceCategoryImp implements iServiceCategory {
   @Autowired
   private iRepositoryCategory iRepositoryCategory;

    @Override
    public boolean create(Category category) {
        return iRepositoryCategory.create(category);
    }


    @Override
    public boolean update(Category category) {
        return iRepositoryCategory.update(category);
    }

    @Override
    public Category findById(int id) {
        return iRepositoryCategory.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return iRepositoryCategory.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        return iRepositoryCategory.deleteById(id);
    }
}
