package com.codegym.service;

import com.codegym.model.Declaration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class serviceImp implements iService {

    private List<Declaration> declarationList  = new ArrayList<>();

    @Override
    public List<Declaration> findAll() {
        return declarationList ;
    }

    @Override
    public void saveDeclaration(Declaration declaration) {
        declarationList .add(declaration);
    }
}
