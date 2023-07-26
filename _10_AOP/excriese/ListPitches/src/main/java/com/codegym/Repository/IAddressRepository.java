package com.codegym.Repository;

import com.codegym.Entity.Address;
import com.codegym.Entity.FootballPitches;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address,Integer> {

}
