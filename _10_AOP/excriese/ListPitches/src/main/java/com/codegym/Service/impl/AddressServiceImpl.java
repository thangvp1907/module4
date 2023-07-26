package com.codegym.Service.impl;

import com.codegym.Entity.Address;
import com.codegym.Entity.FootballPitches;
import com.codegym.Repository.IAddressRepository;
import com.codegym.Service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {
    private final IAddressRepository repository;

    public AddressServiceImpl(IAddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Address> findAll() {
        return repository.findAll();
    }

    @Override
    public Address FindById(Integer id) {
        return repository.findById(id).orElse(null);
    }


}
