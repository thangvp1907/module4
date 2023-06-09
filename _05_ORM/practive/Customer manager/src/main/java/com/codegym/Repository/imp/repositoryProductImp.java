package com.codegym.Repository.imp;

import com.codegym.Entity.Product;
import com.codegym.Repository.iRepositoryProduct;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class repositoryProductImp implements iRepositoryProduct {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("select p from Product p").getResultList();
    }

    @Override
    public boolean create(Product product) {
        entityManager.persist(product);
        return true;
    }

    @Override
    public boolean update(Product product) {
        entityManager.merge(product);
        return true;
    }

    @Override
    public boolean delete(int id) {
        entityManager.remove(findById(id));
        return true;
    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }

    @Override
    public List<Product> findByCate(int cate) {
        return null;
    }
}
