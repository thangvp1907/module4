package com.codegym.Repository;

import com.codegym.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {


    Page<Product> findProductByNameProductContaining(String name, Pageable pageable);
    Page<Product> findProductByPrice( double price, Pageable pageable);

    Page<Product> findProductByCategory_Id(Integer id, Pageable pageable);

}
