package com.codegym.Service;

import com.codegym.Entity.Client;
import com.codegym.Entity.FootballPitches;

import java.util.List;

public interface IClientService {

    List<Client> findAll();

    Client findById(Integer id);

    Client order(Client client);

}
