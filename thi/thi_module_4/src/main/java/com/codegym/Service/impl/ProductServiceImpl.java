package com.codegym.Service.impl;

import com.codegym.Entity.Product;
import com.codegym.Repository.IProductRepository;
import com.codegym.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

    private final IProductRepository iProductRepository;


    public ProductServiceImpl(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public boolean create(Product product) {
         iProductRepository.save(product);
         return true;
    }

    @Override
    public boolean delete(Integer id) {
        iProductRepository.deleteById(id);
        return true;
    }

    @Override
    public Product findById(Integer id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Product> findProductByNameProductContaining(String name,Pageable pageable) {
        return iProductRepository.findProductByNameProductContaining(name,pageable);
    }

    @Override
    public Page<Product> findProductByCategory_Id(Integer id, Pageable pageable) {
        return iProductRepository.findProductByCategory_Id(id,pageable);
    }

    @Override
    public Page<Product> findProductByPrice( Double price, Pageable pageable) {
        return iProductRepository.findProductByPrice(price,pageable);
    }
}
