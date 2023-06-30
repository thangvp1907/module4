package com.codegym.Service.impl;

import com.codegym.Entity.Picture;
import com.codegym.Repository.IRepository;
import com.codegym.Service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements IService {
    private final IRepository repository;

    public ServiceImpl(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Picture> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Picture> findAllToday(String date) {
        return repository.findAllToday(date);
    }

    @Override
    public Picture findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean addComment(Picture picture) {
        picture.setDate();
        repository.save(picture);
        return true;
    }

    @Override
    public boolean addLike(Picture picture) throws Exception {
        if(picture.getLike() < 1) {
            int newLike = picture.getLike() + 1;
            picture.setLike(newLike);
            repository.save(picture);
        }else {
            return false;
        }
        return true;
    }


}
