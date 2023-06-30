package com.codegym.Repository;

import com.codegym.Entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IBlogRepo extends JpaRepository<Blog, Integer> {

}
