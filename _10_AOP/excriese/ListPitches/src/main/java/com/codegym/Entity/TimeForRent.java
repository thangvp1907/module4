package com.codegym.Entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class TimeForRent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String time;

    private Long price;

    @OneToMany(mappedBy = "time", cascade = CascadeType.ALL)
    private List<FootballPitches> timeList;
}
