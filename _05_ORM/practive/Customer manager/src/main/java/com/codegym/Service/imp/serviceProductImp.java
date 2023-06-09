package com.codegym.Service.imp;

import com.codegym.Entity.Product;
import com.codegym.Repository.iRepositoryProduct;
import com.codegym.Service.iServiceProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class serviceProductImp implements iServiceProduct {

    private final iRepositoryProduct iRepositoryProduct;

    public serviceProductImp(iRepositoryProduct iRepositoryProduct) {
        this.iRepositoryProduct = iRepositoryProduct;
    }

    @Override
    public Product findById(int id) {
        return iRepositoryProduct.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return iRepositoryProduct.findAll();
    }


    @Override
    public boolean create(Product product) {
        return iRepositoryProduct.create(product);
    }

    @Override
    public boolean update(Product product) {
        return iRepositoryProduct.update(product);
    }

    @Override
    public boolean delete(int id) {
        return iRepositoryProduct.delete(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return iRepositoryProduct.findByName(name);
    }

    @Override
    public List<Product> findByCate(int cate) {
        return iRepositoryProduct.findByCate(cate);
    }
}
