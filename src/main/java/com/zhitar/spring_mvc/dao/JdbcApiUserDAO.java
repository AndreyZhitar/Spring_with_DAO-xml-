package com.zhitar.spring_mvc.dao;

import com.zhitar.spring_mvc.model.User;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
@Component
public class JdbcApiUserDAO implements UserDAO{

    private static Connection connection;

    static {
        String url = null;
        String username = null;
        String password = null;
        String driver = null;

        try (InputStream stream = JdbcApiUserDAO.class.getClassLoader().getResourceAsStream("persistence.properties")) {
            Properties properties = new Properties();
            properties.load(stream);
            url = properties.getProperty("db.url");
            username = properties.getProperty("db.name");
            password = properties.getProperty("db.password");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
        }
    }

    public List<User> findAll() {
        List<User> users= new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                User user = new User();
                user.setId(set.getInt(1));
                user.setName(set.getString(2));
                user.setSurname(set.getString(3));
                user.setEmail(set.getString(4));
                user.setPassword(set.getString(5));
                users.add(user);
            }
        } catch (SQLException ignore) {
        }
        return users;
    }

    public void save(User user) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("insert into users values (default, ?, ?, ?, ?)");
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.execute();
        } catch (SQLException ignore) {
        }
    }

    public User getOne(String email) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email=?");
            statement.setString(1, email);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                User user = new User();
                user.setId(set.getInt(1));
                user.setName(set.getString(2));
                user.setSurname(set.getString(3));
                user.setEmail(set.getString(4));
                user.setPassword(set.getString(5));
                return user;
            }
        } catch (SQLException ignored) {
        }
        return null;
    }
}
