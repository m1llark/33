package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
    @Transactional
    @Override
    public void removeUser(int id) {
        User user = getUserById(id);
        entityManager.remove(user);
    }
    @Transactional(readOnly=true)
    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }
    @Transactional(readOnly=true)
    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("select u from User u",User.class).getResultList();
    }
}
