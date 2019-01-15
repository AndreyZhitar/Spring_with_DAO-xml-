package com.zhitar.spring_mvc.service;

import com.zhitar.spring_mvc.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    void save(User user);
    User getOne(String email);
}
