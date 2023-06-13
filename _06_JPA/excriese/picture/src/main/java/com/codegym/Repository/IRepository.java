package com.codegym.Repository;

import com.codegym.Entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRepository extends JpaRepository<Picture, Integer> {

    @Query(value = "select p from Picture p  where p.date = :date")
    List<Picture> findAllToday(@Param("date") String date);


}
