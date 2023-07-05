package com.codegym.Service;

import com.codegym.Entity.Book;
import com.codegym.Entity.Oder;

import java.util.List;
import java.util.Optional;

public interface IOderService {
    List<Oder> findAll();

    Optional<Oder> findById(Integer id);

    Boolean create(Oder oder);
    
}
