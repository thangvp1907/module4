package com.codegym.Service.Impl;

import com.codegym.Entity.Book;
import com.codegym.Repository.IBookRepository;
import com.codegym.Service.IBookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements IBookService {

    final IBookRepository iBookRepository;

    public BookServiceImpl(IBookRepository iBookRepository) {
        this.iBookRepository = iBookRepository;
    }

    @Override
    public List<Book> findAll(){
         return iBookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return iBookRepository.findById(id);
    }

    @Override
    public Boolean create(Book book) {
        iBookRepository.save(book);
        return true;
    }
}
