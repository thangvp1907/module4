package com.codegym.Service.impl;

import com.codegym.Entity.Client;
import com.codegym.Repository.IClientRepository;
import com.codegym.Service.IClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements IClientService {
    private final IClientRepository repository;

    public ClientServiceImpl(IClientRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public Client findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Client order(Client client) {
        return repository.save(client);
    }

}
