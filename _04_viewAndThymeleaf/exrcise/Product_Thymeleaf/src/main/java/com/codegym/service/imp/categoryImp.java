package com.codegym.service.imp;

import com.codegym.model.Category;
import com.codegym.service.iCategory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class categoryImp implements iCategory {
    public static Map<Integer, Category> categoryMap;
    static {
        categoryMap = new HashMap<>();
        categoryMap.put(1, new Category(1, "Laptop"));
        categoryMap.put(2, new Category(2, "Smartphone"));
        categoryMap.put(3, new Category(3, "Tivi"));
        categoryMap.put(4, new Category(4, "Tu lanh"));
    }
    @Override
    public boolean create(Category category) {
        if (categoryMap.containsKey(category.getCategoryId())) {
            return false;
        }

        categoryMap.put(category.getCategoryId(), category);
        return true;
    }

    @Override
    public boolean update(Category category) {
        if (categoryMap.containsKey(category.getCategoryId())) {
            categoryMap.put(category.getCategoryId(), category);
            return true;
        }

        return false;
    }

    @Override
    public  Category findById(int id) {
        return categoryMap.get(id);
    }

    @Override
    public List<Category> findAll() {
        return new ArrayList<>(categoryMap.values());
    }

    @Override
    public boolean deleteById(int id) {
        if (categoryMap.containsKey(id)) {
            categoryMap.remove(id);
            return true;
        }
        return false;
    }
}
