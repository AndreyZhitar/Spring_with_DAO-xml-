package com.zhitar.spring_mvc.dao;

import com.zhitar.spring_mvc.model.User;

import java.util.List;

public interface UserDAO {

    List<User> findAll();
    void save(User user);
    User getOne(String email);
}
