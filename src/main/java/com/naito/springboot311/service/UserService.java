package com.naito.springboot311.service;

import com.naito.springboot311.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User save(User user);

    User getById(Long id);

    void deleteById(Long id);

    User findByUsername(String username);

}
