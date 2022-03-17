package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> index () {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User show (Long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(Long id, User updateUser) {
        entityManager.merge(updateUser);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(show(id));
     }
}
