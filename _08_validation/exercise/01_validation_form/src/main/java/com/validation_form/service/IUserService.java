package com.validation_form.service;

import com.validation_form.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void save(User user);
}
