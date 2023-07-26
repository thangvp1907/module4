package com.codegym.Service;

import com.codegym.Entity.FootballPitches;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface IFootballPitchesService  {

    Page<FootballPitches> findAll(Pageable pageable);

    FootballPitches findById(Integer id);

    List<FootballPitches> order(FootballPitches footballPitches);


    boolean create(FootballPitches footballPitches);


    Page<FootballPitches> findFootballPitchesByNamePitchesContaining (String name,Pageable pageable);


    boolean delete(Integer id);

    Page<FootballPitches> findFootballPitchesByAddress_Id (Integer id,Pageable pageable);


}
