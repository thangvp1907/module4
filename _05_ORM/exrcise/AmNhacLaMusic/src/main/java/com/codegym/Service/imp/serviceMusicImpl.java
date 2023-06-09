package com.codegym.Service.imp;

import com.codegym.Entity.Music;
import com.codegym.Repository.iRepositoryMusic;
import com.codegym.Service.iServiceMusic;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class serviceMusicImpl  implements iServiceMusic {
    private final iRepositoryMusic repositoryMusic;

    public serviceMusicImpl(iRepositoryMusic repositoryMusic) {
        this.repositoryMusic = repositoryMusic;
    }

    @Override
    public List<Music> findAll() {
        return (List<Music>) repositoryMusic.findAll();
    }

    @Override
    public Music findById(int id) {
        return repositoryMusic.findById(id).orElse(null);
    }

    @Override
    public void create(Music music) {
        repositoryMusic.save(music);
    }

    @Override
    public void delete(int id) {
        repositoryMusic.deleteById(id);
    }
}
