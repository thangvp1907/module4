package com.codegym.service;



import com.codegym.model.Declaration;

import java.util.List;

public interface iService {
    List<Declaration> findAll();

    void saveDeclaration (Declaration declaration);
}
