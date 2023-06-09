package com.codegym.service.imp;

import com.codegym.model.Product;
import com.codegym.service.iCategory;
import com.codegym.service.iProduct;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class productImp implements iProduct {
    private Map<Integer, Product> productMap = new HashMap<>();

    public productImp() {
        iCategory category = new categoryImp();
        Date date = null;
        try {
            date = (new SimpleDateFormat("dd/MM/yyyy")).parse("01/01/2023");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        productMap.put(1, new Product(1, "Samsung S23", 5, date, 15000000, category.findById(2)));
        productMap.put(2, new Product(2, "Iphone 14", 7, date, 19000000, category.findById(2)));
        productMap.put(3, new Product(3, "Laptop lenovo legion", 2, date, 20000000, category.findById(1)));

    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public boolean create(Product product) {
        if (productMap.containsKey(product.getId())) {
            return false;
        }
        productMap.put(product.getId(), product);
        return true;
    }

    @Override
    public boolean update(Product product) {
        if (productMap.containsKey(product.getId())) {
            productMap.put(product.getId(), product);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (productMap.containsKey(id)) {
            productMap.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        for (Product c : productMap.values()) {
            if (c.getName().toLowerCase().contains(name.toLowerCase())) {
                products.add(c);
            }
        }
        return products;
    }

    @Override
    public List<Product> findByCate(int cate) {
        List<Product> products = new ArrayList<>();
        for(Product c : productMap.values()){
            if(c.getCategory().getCategoryId() == cate ){
                products.add(c);
            }
        }
        return products;
    }
}

