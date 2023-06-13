package com.codegym.Service;

import com.codegym.Entity.Picture;

import java.util.List;

public interface IService {
    List<Picture> findAll();
    List<Picture> findAllToday(String date);
    Picture findById(int id);
    boolean addComment(Picture picture);
    boolean addLike(Picture picture) throws Exception ;
}
