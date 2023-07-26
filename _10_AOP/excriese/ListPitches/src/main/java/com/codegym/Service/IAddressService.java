package com.codegym.Service;

import com.codegym.Entity.Address;
import com.codegym.Entity.FootballPitches;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IAddressService {

    List<Address> findAll();

    Address FindById(Integer id);


}
