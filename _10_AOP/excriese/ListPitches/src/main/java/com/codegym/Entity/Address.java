package com.codegym.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nameAddress;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private List<FootballPitches> footballPitchesList;

}
