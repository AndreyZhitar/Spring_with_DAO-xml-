package com.zhitar.spring_mvc.dao;

import com.zhitar.spring_mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class JdbcTemplateUserDAO implements UserDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper<>(User.class));
    }

    public void save(User user) {
        jdbcTemplate.update("insert into users values (default, ?, ?, ?, ?)", user.getName(), user.getSurname(), user.getEmail(), user.getPassword());
    }

    public User getOne(String email) {
        return jdbcTemplate.query("SELECT * FROM users WHERE email=?", new Object[]{email}, new BeanPropertyRowMapper<>(User.class)).stream().findAny().orElse(null);
    }
}
