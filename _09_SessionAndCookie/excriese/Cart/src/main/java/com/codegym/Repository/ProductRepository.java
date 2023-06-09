package com.codegym.Repository;

import com.codegym.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product,Integer> {

    Optional<Product> findById(Integer id);
}
