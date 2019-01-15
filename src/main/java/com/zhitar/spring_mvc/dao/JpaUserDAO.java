package com.zhitar.spring_mvc.dao;


import com.zhitar.spring_mvc.model.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Component
@Transactional(readOnly = true)
public class JpaUserDAO implements UserDAO {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getOne(String email) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.email = :email", User.class);
        query.setParameter("email", email);
        return query.getResultList().stream().findAny().orElse(null);
    }
}
