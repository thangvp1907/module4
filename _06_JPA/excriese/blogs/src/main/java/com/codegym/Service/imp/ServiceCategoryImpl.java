package com.codegym.Service.imp;

import com.codegym.Entity.Category;
import com.codegym.Repository.ICategoryRepo;
import com.codegym.Service.IServiceCategory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ServiceCategoryImpl implements IServiceCategory {
    public final ICategoryRepo iCategoryRepo;

    public ServiceCategoryImpl(ICategoryRepo iCategoryRepo) {
        this.iCategoryRepo = iCategoryRepo;
    }

    @Override
    public boolean create(Category category) {
        iCategoryRepo.save(category);
        return true;
    }

    @Override
    public boolean update(Category category) {
        if (iCategoryRepo.existsById(category.getIdCategory())) {
            iCategoryRepo.save(category);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        if(iCategoryRepo.existsById(id)) {
            iCategoryRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Category findById(int id) {
        return iCategoryRepo.findById(id).orElse(null);
    }

    @Override
    public List<Category> findAll() {
        return  iCategoryRepo.findAll();
    }
}
