package com.codegym.Repository;

import com.codegym.Entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface iRepositoryMusic extends CrudRepository<Music, Integer> {

}
