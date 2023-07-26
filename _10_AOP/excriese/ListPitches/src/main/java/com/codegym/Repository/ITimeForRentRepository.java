package com.codegym.Repository;

import com.codegym.Entity.TimeForRent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITimeForRentRepository extends JpaRepository<TimeForRent,Integer> {


}
