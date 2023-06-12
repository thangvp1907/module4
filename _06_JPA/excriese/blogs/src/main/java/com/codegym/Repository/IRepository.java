package com.codegym.Repository;

import com.codegym.Entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IRepository extends CrudRepository<Blog, Integer> {

}
