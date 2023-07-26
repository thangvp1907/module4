package com.codegym.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@Validated
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Tên không được để trống!!")
    private String nameClient;
    @NotBlank(message = " Số điện thoại không được để trống!!")
    private String numberPhone;

    @ManyToOne
    @JoinColumn(name = "id_pitches", referencedColumnName = "id")
    private FootballPitches footballPitches;

}
