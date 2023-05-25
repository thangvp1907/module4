package com.codegym.service;

import com.codegym.model.Mail;

import java.util.List;

public interface iService {
    List<Mail> findAll();

    Mail findById(int id);

    List<String> findByLanguagesList();

    List<Integer> findByPageSize();

    void save(Mail mail);

}
