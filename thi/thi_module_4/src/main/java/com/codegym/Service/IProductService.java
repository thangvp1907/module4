package com.codegym.Service;

import com.codegym.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {

    Page<Product> findAll(Pageable pageable);

    boolean create(Product product);

    boolean delete(Integer id);

    Product findById(Integer id);

    Page<Product> findProductByNameProductContaining (String name,Pageable pageable);

    Page<Product> findProductByCategory_Id(Integer id, Pageable pageable);

    Page<Product> findProductByPrice(Double price, Pageable pageable);


}
