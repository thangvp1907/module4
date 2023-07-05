package com.codegym.Service.Impl;

import com.codegym.Entity.Book;
import com.codegym.Entity.Oder;
import com.codegym.Repository.IOderRepository;
import com.codegym.Service.IBookService;
import com.codegym.Service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OderServiceImpl implements IOderService {
    final
    IOderRepository iOderRepository;

    public OderServiceImpl(IOderRepository iOderRepository) {
        this.iOderRepository = iOderRepository;
    }

    @Override
    public List<Oder> findAll() {
        return iOderRepository.findAll();
    }

    @Override
    public Optional<Oder> findById(Integer id) {
        return iOderRepository.findById(id);
    }

    @Override
    public Boolean create(Oder oder) {
        iOderRepository.save(oder);
        return true;
    }
}
