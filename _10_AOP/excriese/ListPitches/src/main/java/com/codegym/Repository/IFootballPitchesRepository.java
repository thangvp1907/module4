package com.codegym.Repository;

import com.codegym.Entity.FootballPitches;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFootballPitchesRepository extends JpaRepository<FootballPitches, Integer> {
    Page<FootballPitches> findFootballPitchesByNamePitchesContaining (String name,Pageable pageable);

    Page<FootballPitches> findFootballPitchesByAddress_Id (Integer id,Pageable pageable);

}
