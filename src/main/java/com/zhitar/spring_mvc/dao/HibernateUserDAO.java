package com.zhitar.spring_mvc.dao;

import com.zhitar.spring_mvc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class HibernateUserDAO implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.openSession();
    }
    @Override
    public List<User> findAll() {
        return currentSession().createQuery("from User", User.class).list();
    }

    @Override
    public void save(User user) {
        currentSession().save(user);
    }

    @Override
    public User getOne(String email) {
        Query<User> query = currentSession().createQuery("from User where email =:email", User.class);
        query.setParameter("email", email);
        return query.list().stream().findAny().orElse(null);
    }
}
