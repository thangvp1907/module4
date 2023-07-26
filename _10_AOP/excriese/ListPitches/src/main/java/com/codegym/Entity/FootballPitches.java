package com.codegym.Entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Setter
@Getter
@Validated
public class FootballPitches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Tên không được để trống!!")
    private String namePitches;

    @ManyToOne
    @JoinColumn(name = "id_address", referencedColumnName = "id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "id_time", referencedColumnName = "id")
    private TimeForRent time;


    @OneToMany(mappedBy = "footballPitches", cascade = CascadeType.ALL)
    private List<Client> clients;
}