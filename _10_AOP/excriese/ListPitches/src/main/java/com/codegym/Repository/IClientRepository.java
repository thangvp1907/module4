package com.codegym.Repository;

import com.codegym.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Client,Integer> {
}
