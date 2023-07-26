package com.codegym.Service.impl;

import com.codegym.Entity.FootballPitches;
import com.codegym.Entity.TimeForRent;
import com.codegym.Repository.ITimeForRentRepository;
import com.codegym.Service.ITimeForRentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeForRentServiceImpl implements ITimeForRentService {
    private final ITimeForRentRepository repository;

    public TimeForRentServiceImpl(ITimeForRentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TimeForRent> findAll() {
        return repository.findAll();
    }

    @Override
    public TimeForRent findById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
