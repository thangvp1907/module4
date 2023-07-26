package com.codegym.Service;

import com.codegym.Entity.FootballPitches;
import com.codegym.Entity.TimeForRent;

import java.util.List;

public interface ITimeForRentService {

    List<TimeForRent> findAll();


    TimeForRent findById(Integer id);

}
