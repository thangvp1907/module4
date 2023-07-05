package com.codegym.Service;

import com.codegym.Entity.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> findAll();

    Optional<Book> findById(Integer id);

    Boolean create(Book book);
}
