package com.validation_music.repository;

import com.validation_music.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMusicRepository extends JpaRepository<Music,Integer> {
    Music findById(int id);
}
